package com.keduit.bird.service;

import com.keduit.bird.constant.Role;
import com.keduit.bird.dto.BoardDTO;
import com.keduit.bird.entity.Board;
import com.keduit.bird.entity.BoardImg;
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
        System.out.println("등록 메서드 도착");
        System.out.println("등록 메서드 boardDTO : " + boardDTO);
        System.out.println("등록 메서드 boardImgFileList : " + boardImgFileList);
        Member member = memberRepository.findByMemberEmail(email);
        System.out.println("등록 메서드 email : " + member.getMemberEmail());

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

//    public Page<BoardDTO> getBoardPage(Pageable pageable) {
//        Page<Board> boardPage = boardRepository.findAll(pageable);
//
//        // Board 엔티티를 BoardDTO로 매핑하여 Page<BoardDTO>로 반환
//        return boardPage.map(board -> new BoardDTO(
//                board.getId(),
//                board.getBoardTitle(),
//                board.getMember().getMemberName(), // 예시: Board 엔티티에 Member가 있다고 가정
//                board.getBoardCreatedTime(),
//                board.getCount()
//        ));
//    }



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
        boardDTO.setBoardTitle(board.getBoardTitle());
        boardDTO.setBoardContent(board.getBoardContent());
        boardDTO.setNickName(board.getMember().getMemberName()); 
        boardDTO.setRegTime(board.getBoardCreatedTime());
        boardDTO.setUpdateTime(board.getBoardUpDatedTime());
        if (boardImg != null) {
            boardDTO.setImgUrl(boardImg.getImgUrl());
        }
    // 게시글이 없다면
    } else {
        throw new RuntimeException("게시물을 찾지 못하였습니다. " + boardId);
    }
    return boardDTO;
}






}
