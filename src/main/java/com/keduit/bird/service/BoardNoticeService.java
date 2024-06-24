package com.keduit.bird.service;

import com.keduit.bird.constant.Role;
import com.keduit.bird.dto.BoardDTO;
import com.keduit.bird.dto.BoardNoticeDTO;
import com.keduit.bird.entity.Board;
import com.keduit.bird.entity.BoardImg;
import com.keduit.bird.entity.BoardNotice;
import com.keduit.bird.entity.Member;
import com.keduit.bird.repository.BoardImgRepository;
import com.keduit.bird.repository.BoardNoticeRepository;
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
public class BoardNoticeService {
    private final BoardNoticeRepository boardNoticeRepository;
    private final BoardImgService boardImgService;
    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final BoardImgRepository boardImgRepository;

    public Long insertBoard(BoardNoticeDTO boardDTO, List<MultipartFile> boardImgFileList,String email) throws Exception {
  
        Member member = memberRepository.findByMemberEmail(email);

//      컨트롤러에서 확인했지만 한번더 확인
        if(member == null){
            throw new UsernameNotFoundException("해당하는 이메일(" + email + ")을 찾을 수 없습니다.");
        }
        if(!member.getRole().equals(Role.ADMIN)){
          throw new IllegalStateException("해당하는 이메일(" + email + ")에는 권한이 없습니다.");
        }
        if(member.getRole().equals(Role.ADMIN)){}
        BoardNotice notice = new BoardNotice();
        notice.setBoardContent(boardDTO.getBoardContent());
        notice.setBoardTitle(boardDTO.getBoardTitle());
        notice.setMember(member);
        boardNoticeRepository.save(notice);
        if (!boardImgFileList.get(0).isEmpty()) {
        for (int i = 0; i < boardImgFileList.size(); i++) {
            BoardImg BoardImg = new BoardImg();
            BoardImg.setBoardNotice(notice);
            boardImgService.saveCommunityImg(BoardImg, boardImgFileList.get(i));
        }
    }
        return notice.getId();
    }
    


    public List<BoardNoticeDTO> getBoardList(){
        List<BoardNotice> boardList = boardNoticeRepository.findAll();

        List<BoardNoticeDTO> boardDTOList = new ArrayList<>();
        for (BoardNotice board : boardList) {
            BoardNoticeDTO boardNotice = new BoardNoticeDTO();
            boardNotice.setId(board.getId());
            boardNotice.setNickName(board.getMember().getMemberName());
            boardNotice.setBoardTitle(board.getBoardTitle());
            boardNotice.setBoardContent(board.getBoardContent());
            boardNotice.setCount(board.getCount());
            boardDTOList.add(boardNotice);
        }
        return boardDTOList;
    }




public Page<BoardNotice> getBoardPage(Pageable pageable, String type, String keyword) {

    if ("titleAndContent".equals(type)) {
        return boardNoticeRepository.findFilterBoard(keyword, pageable);
    } else if ("title".equals(type)) {
        return boardNoticeRepository.findByBoardTitleContaining(keyword, pageable);
    } else if ("content".equals(type)) {
        return boardNoticeRepository.findByBoardContentContaining(keyword, pageable);
    } else if ("writer".equals(type)) {
        return boardNoticeRepository.findByMemberNameContaining(keyword, pageable);
    } else {
        return boardNoticeRepository.findAll(pageable);
    }
}


public BoardNoticeDTO getOneBoard(Long boardId) {


    BoardNoticeDTO boardDTO = new BoardNoticeDTO();
    // 게시글 찾기
    BoardNotice board = boardNoticeRepository.findById(boardId).orElse(null);

    // 이미지 찾기
    BoardImg boardImg = boardImgRepository.findByBoardNoticeId(boardId);

    // 게시글 내용이 있다면
    if (board != null) {
        boardDTO.setId(boardId);
        boardDTO.setEmail(board.getMember().getMemberEmail());
        boardDTO.setBoardTitle(board.getBoardTitle());
        boardDTO.setBoardContent(board.getBoardContent());
        boardDTO.setNickName(board.getMember().getMemberName()); 
        boardDTO.setRegTime(board.getBoardCreatedTime());
        boardDTO.setUpdateTime(board.getBoardUpDatedTime());
        boardDTO.setFileName(boardImg.getImgName());
        if (boardImg != null) {
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
    BoardNotice board = boardNoticeRepository.findById(boardDTO.getId()).orElse(null);
    BoardImg boardImg = boardImgRepository.findByBoardId(board.getId());

    if (member == null) {
        throw new UsernameNotFoundException("회원가입을 해주시기 바랍니다");
    }
    if (board == null) {
        throw new IllegalArgumentException("게시글을 찾을 수 없습니다");
    }
    // 작성자와 수정자 비교, 관리자라면 수정 가능
    if (member.getRole() != Role.ADMIN) {
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
            BoardImg.setBoardNotice(board);
            boardImgService.saveCommunityImg(BoardImg, boardImgFileList.get(i));
        }
    }

    // 게시글 정보를 업데이트
    board.setMember(member);
    board.setBoardTitle(boardDTO.getBoardTitle());
    board.setBoardContent(boardDTO.getBoardContent());
    boardNoticeRepository.save(board);
}




public void boardDelete(Long boardId, String email) {
    // boardId와 email로 보드를 찾습니다.
    BoardNotice board = boardNoticeRepository.findById(boardId).orElse(null);
    Member member = memberRepository.findByMemberEmail(email);
    BoardImg boardImg = boardImgRepository.findByBoardId(boardId);
    if (member == null) {
        throw new UsernameNotFoundException("회원가입을 해주시기 바랍니다");
    }
    if (board == null) {
        throw new IllegalArgumentException("게시글을 찾을 수 없습니다");
    }
       // 작성자와 수정자 비교, 관리자라면 수정 가능
    if (member.getRole() != Role.ADMIN) {
        throw new SecurityException("해당 게시글을 수정할 권한이 없습니다.");
    }
    /// 게시글 삭제
    boardNoticeRepository.delete(board);
    // 이미지삭제
    boardImgRepository.delete(boardImg);
}
   



}







