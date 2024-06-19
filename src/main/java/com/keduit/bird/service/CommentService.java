package com.keduit.bird.service;

import com.keduit.bird.dto.BoardDTO;
import com.keduit.bird.dto.CommentDTO;
import com.keduit.bird.entity.Board;
import com.keduit.bird.entity.BoardComment;
import com.keduit.bird.entity.Member;
import com.keduit.bird.repository.BoardRepository;
import com.keduit.bird.repository.CommentRepository;
import com.keduit.bird.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;


    public Long insertComment(String comment, Long boardId, String email){
        
        Member member = memberRepository.findByMemberEmail(email);
        if(member == null){
            throw new UsernameNotFoundException("해당하는 이메일(" + email + ")을 찾을 수 없습니다.");
        }
        Board board = boardRepository.findById(boardId).orElse(null);
        if(board == null ){
            throw new IllegalArgumentException("해당하는 게시물을 찾을 수 없습니다.");
        }

        BoardComment result = new BoardComment();
        result.setBoard(board);
        result.setContent(comment);
        result.setEmail(email);
        commentRepository.save(result);

        return result.getId();
    }


    public List<CommentDTO> getBoardComment(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(() ->
            new IllegalArgumentException("해당하는 게시물을 찾을 수 없습니다.")
        );
    
        List<BoardComment> comments = commentRepository.findByBoardId(boardId);
        
        List<CommentDTO> commentDTOs = new ArrayList<>();
        for (BoardComment comment : comments) {
            CommentDTO commentDTO = new CommentDTO();
            Member member = memberRepository.findByMemberEmail(comment.getEmail());
            commentDTO.setId(comment.getId());
            commentDTO.setNickName(member.getMemberName());
            commentDTO.setEmail(member.getMemberEmail());
            commentDTO.setCommentContents(comment.getContent());
            commentDTO.setEmail(comment.getEmail());
            commentDTO.setRegTime(comment.getBoardCreatedTime());
            commentDTOs.add(commentDTO);
        }
    
        return commentDTOs;
    }

    public void commentUpdate(CommentDTO boardComment){
        System.out.println("업데이트 메서드옴");

    }



}



