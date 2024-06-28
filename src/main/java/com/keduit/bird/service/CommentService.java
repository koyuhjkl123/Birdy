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

import javax.management.relation.Role;

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
        Member member = memberRepository.findByMemberEmail(boardComment.getEmail());
        BoardComment comment = new BoardComment();
        Board board = boardRepository.findById(boardComment.getBoardId()).orElse(null);
        comment.setEmail(boardComment.getEmail());
        comment.setContent(boardComment.getCommentContents());
        comment.setId(boardComment.getId());
        comment.setBoard(board);
        if(member == null){
            throw new UsernameNotFoundException("해당하는 이메일(" + boardComment.getEmail() + ")을 찾을 수 없습니다.");
        }

        if(board == null ){
            throw new IllegalArgumentException("해당하는 게시물을 찾을 수 없습니다.");
        }
        BoardComment boardComment2 = commentRepository.findById(boardComment.getId()).orElse(null);     
        if(member.getRole() == com.keduit.bird.constant.Role.ADMIN){
        // 업데이트 하는곳 절차지향 특징 사용
        commentRepository.save(comment);
        }
        // boardComment DTO에 담아서 온거 boardComment2 기존에 데이터 가져와서 비교
        if (!boardComment.getEmail().equals(boardComment2.getEmail()) && member.getRole() != com.keduit.bird.constant.Role.ADMIN) {
            throw new UsernameNotFoundException("본인이 작성한 댓글이 아닙니다.");
        }
        commentRepository.save(comment);
    }




    public void commentDelete(Long commentId, String email) {
        Member member = memberRepository.findByMemberEmail(email);
        if (member == null) {
            throw new UsernameNotFoundException("해당하는 이메일(" + email + ")을 찾을 수 없습니다.");
        }
        BoardComment boardComment = commentRepository.findById(commentId).orElseThrow(() ->
            new IllegalArgumentException("해당하는 댓글을 찾을 수 없습니다.")
        );

        // 관리자가 아니고 댓글 작성자가 아닌 경우 예외 발생
        if (!boardComment.getEmail().equals(email) && member.getRole() != com.keduit.bird.constant.Role.ADMIN) {
            throw new UsernameNotFoundException("본인이 작성한 댓글이 아닙니다.");
        }
        commentRepository.delete(boardComment);
    }


    //내가 쓴 댓글 조회
    public List<BoardComment> getCommentByWriter(String email) {
        return commentRepository.findByEmail(email);
    }
}



