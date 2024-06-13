package com.keduit.bird.service;

import com.keduit.bird.dto.BoardDTO;
import com.keduit.bird.entity.Board;
import com.keduit.bird.entity.BoardImg;
import com.keduit.bird.entity.Member;
import com.keduit.bird.repository.BoardImgRepository;
import com.keduit.bird.repository.BoardRepository;
import com.keduit.bird.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
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

    public Long saveBoard(BoardDTO boardDTO, List<MultipartFile> boardImgFileList,String email) throws Exception {
        Member member = memberRepository.findByMemberEmail(email);
        if(member == null){
            throw new UsernameNotFoundException("해당하는 이메일(" + email + ")을 찾을 수 없습니다.");
        }
        Board board = new Board();
        board.setBoardContent(boardDTO.getBoardContent());
        board.setBoardTitle(boardDTO.getBoardTitle());
        board.setMember(member);
//        Board board = boardRepository.save(boardDTO);
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
            boardDTOList.add(boardDTO);
        }
        return boardDTOList;
    }




}
