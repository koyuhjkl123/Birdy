package com.keduit.bird.service;

import com.keduit.bird.constant.Role;
import com.keduit.bird.dto.BoardDTO;
import com.keduit.bird.entity.Board;
import com.keduit.bird.entity.BoardImg;
import com.keduit.bird.entity.BoardNotice;
import com.keduit.bird.entity.Member;
import com.keduit.bird.repository.BoardImgRepository;
import com.keduit.bird.repository.BoardRepository;
import com.keduit.bird.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardImgService boardImgService;
    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final BoardImgRepository boardImgRepository;

    public Long insertBoard(BoardDTO boardDTO, List<MultipartFile> boardImgFileList,String email) throws Exception {
  
        Member member = memberRepository.findByMemberEmail(email);

//      컨트롤러에서 확인했지만 한번더 확인
        if(member == null){
            throw new UsernameNotFoundException("해당하는 이메일(" + email + ")을 찾을 수 없습니다.");
        }
        if(member.getRole().equals(Role.STOP)){
          throw new IllegalStateException("해당하는 이메일(" + email + ")을 정지된 회원입니다.");
        }
        Board board = new Board();
        board.setBoardContent(boardDTO.getBoardContent());
        board.setBoardTitle(boardDTO.getBoardTitle());
        board.setMember(member);
        boardRepository.save(board);
        for (int i = 0; i < boardImgFileList.size(); i++) {
            BoardImg BoardImg = new BoardImg();
            BoardImg.setBoard(board);
            boardImgService.saveCommunityImg(BoardImg, boardImgFileList.get(i));
        }
        return board.getId();
    }


    public List<BoardDTO> getBoardList(){
        List<Board> boardList = boardRepository.findAll();
        String nickName;

        List<BoardDTO> boardDTOList = new ArrayList<>();
        for (Board board : boardList) {
            BoardDTO boardDTO = new BoardDTO();
            boardDTO.setId(board.getId());
            boardDTO.setNickName(board.getMember().getMemberName());
            boardDTO.setBoardTitle(board.getBoardTitle());
            boardDTO.setBoardContent(board.getBoardContent());
            boardDTO.setCount(board.getCount());
            boardDTOList.add(boardDTO);
        }
        return boardDTOList;
    }




public Page<Board> getBoardPage(Pageable pageable, String type, String keyword) {
    System.out.println("서비스 코드 도착");
    System.out.println("keyword"+keyword);
    if ("titleAndContent".equals(type)) {
        System.out.println("첫번째 문");
        return boardRepository.findFilterBoard(keyword, pageable);
    } else if ("title".equals(type)) {
        System.out.println("2번째 문");
        return boardRepository.findByBoardTitleContaining(keyword, pageable);
    } else if ("content".equals(type)) {
        System.out.println("3번째 문");
        return boardRepository.findByBoardContentContaining(keyword, pageable);
    } else if ("writer".equals(type)) {
        System.out.println("4번째 문");
        return boardRepository.findByMemberNameContaining(keyword, pageable);
    } else {
        System.out.println("마지막");
        return boardRepository.findAll(pageable);
    }
}


public BoardDTO getOneBoard(Long boardId) {

    BoardDTO boardDTO = new BoardDTO();
    // 게시글 찾기
    Board board = boardRepository.findById(boardId).orElse(null);

    // 이미지 찾기
    BoardImg boardImg = boardImgRepository.findByBoardId(boardId);

    // 게시글 내용이 있다면
    if (board != null) {
        boardDTO.setId(boardId);
        boardDTO.setEmail(board.getMember().getMemberEmail());
        boardDTO.setBoardTitle(board.getBoardTitle());
        boardDTO.setBoardContent(board.getBoardContent());
        boardDTO.setNickName(board.getMember().getMemberName()); 
        boardDTO.setRegTime(board.getBoardCreatedTime());
        boardDTO.setUpdateTime(board.getBoardUpDatedTime());
        boardDTO.setCount(board.getCount());

        if (boardImg != null) {
            boardDTO.setFileName(boardImg.getImgName());
            boardDTO.setImgUrl(boardImg.getImgUrl());
            boardDTO.setOriImgName(boardImg.getOriImgName());
        }
    // 게시글이 없다면
    } else {
        throw new RuntimeException("게시물을 찾지 못하였습니다. " + boardId);
    }
    return boardDTO;
}



public void boardUpdate(BoardDTO boardDTO, List<MultipartFile> boardImgFileList, String email) throws Exception {
    System.out.println("서비스 업데이트 도착");
    System.out.println("서비스 업데이트 boardDTO" + boardDTO.toString());
    System.out.println("서비스 업데이트 boardImgFileList++++" + boardImgFileList.isEmpty());
    Member member = memberRepository.findByMemberEmail(email);
    Board board = boardRepository.findById(boardDTO.getId()).orElse(null);
    BoardImg boardImg = boardImgRepository.findByBoardId(board.getId());

    if (member == null) {
        throw new UsernameNotFoundException("회원가입을 해주시기 바랍니다");
    }
    if (board == null) {
        throw new IllegalArgumentException("게시글을 찾을 수 없습니다");
    }
    // 작성자와 수정자 비교, 관리자라면 수정 가능
    if (!board.getMember().getMemberEmail().equals(email) && member.getRole() != Role.ADMIN) {
        throw new SecurityException("해당 게시글을 수정할 권한이 없습니다.");
    }

    // 이미지 삭제 로직
    if (boardDTO.isDeleteImg()) {
        System.out.println("이미지 삭제 조건문");
        boardImgRepository.delete(boardImg);
    } 
    // 하나의 이미지만 받아서 첫번쨰 자리로 해결  boardImgFileList.isEmty() 파일 존재 자체 유무를 판단한다고함.
    else if (!boardImgFileList.get(0).isEmpty()) {
        System.out.println("이미지 파일 리스트가 비어 있지 않음");
        // 기존 이미지 삭제 및 새로운 이미지 저장
        if (boardImg != null) {
            System.out.println("기존 이미지 삭제");
            boardImgRepository.delete(boardImg);
        }
        for (int i = 0; i < boardImgFileList.size(); i++) {
            BoardImg BoardImg = new BoardImg();
            BoardImg.setBoard(board);
            boardImgService.saveCommunityImg(BoardImg, boardImgFileList.get(i));
        }
    }

    // 게시글 정보를 업데이트
    board.setMember(member);
    board.setBoardTitle(boardDTO.getBoardTitle());
    board.setBoardContent(boardDTO.getBoardContent());
    boardRepository.save(board);
}




public void boardDelete(Long boardId, String email) {
    // boardId와 email로 보드를 찾습니다.
    Board board = boardRepository.findById(boardId).orElse(null);
    Member member = memberRepository.findByMemberEmail(email);
    BoardImg boardImg = boardImgRepository.findByBoardId(boardId);
    if (member == null) {
        throw new UsernameNotFoundException("회원가입을 해주시기 바랍니다");
    }
    if (board == null) {
        throw new IllegalArgumentException("게시글을 찾을 수 없습니다");
    }
       // 작성자와 수정자 비교, 관리자라면 수정 가능
    if (!board.getMember().getMemberEmail().equals(email) && member.getRole() != Role.ADMIN) {
        throw new SecurityException("해당 게시글을 수정할 권한이 없습니다.");
    }
    /// 게시글 삭제
    boardRepository.delete(board);
    // 이미지삭제
    boardImgRepository.delete(boardImg);
}

    public Board increaseViewCount(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(EntityNotFoundException::new);

        // 조회수를 1 증가시킵니다.
        board.setCount(board.getCount() + 1);

        // 증가된 조회수를 저장하고 업데이트된 BoardCommunity 객체를 반환합니다.
        return boardRepository.save(board);
    }

//내가 쓴 글 찾기(mpage 기능)
    public List<Board> getBoardsByCurrentMember(String memberName) {
        return boardRepository.findByMemberName(memberName);
    }

}







