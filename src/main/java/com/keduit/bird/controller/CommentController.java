package com.keduit.bird.controller;

import com.keduit.bird.dto.CommentDTO;
import com.keduit.bird.service.CommentService;
import com.keduit.bird.repository.BoardImgRepository;
import com.keduit.bird.repository.BoardRepository;
import com.keduit.bird.repository.CommentRepository;
import com.keduit.bird.entity.Board;
import com.keduit.bird.entity.BoardComment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @PostMapping("/insert/{boardId}")
    public ResponseEntity<String>  reviewWrite(@PathVariable Long boardId,
                              @RequestBody Map<String, String> requestData,
                              Principal principal) {

       try {
            String comment = requestData.get("comment");
            System.out.println("review테스트: " + comment);
            commentService.insertComment(comment, boardId, principal.getName());
            return new ResponseEntity<>("댓글 등록 완료.", HttpStatus.OK);
        } 
        // 서비스에서 구현한 Exceptiom 처리
        catch (UsernameNotFoundException | IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        } 
        // 그밖의 에러 처리 
        catch (Exception e) {
            return new ResponseEntity<>("서버 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PutMapping("/update/{commentId}")
    public ResponseEntity<String> commentUpdate(@PathVariable Long commentId,
                                                @RequestBody Map<String, String> requestData,
                                                BindingResult bindingResult,
                                                Principal principal) {
        try {
            System.out.println("컨트롤러 들옴..!!");
            Long boardId = Long.parseLong(requestData.get("boardId"));
            String comment = requestData.get("comment");
            String email = principal.getName();
            CommentDTO boardComment = new CommentDTO();
            boardComment.setId(commentId);
            boardComment.setEmail(email);
            boardComment.setCommentContents(comment);
            boardComment.setBoardId(boardId);
            System.out.println("boardComment: " + boardComment.toString());

            commentService.commentUpdate(boardComment);
            return new ResponseEntity<>("댓글 업데이트 완료.", HttpStatus.OK);
        } catch (UsernameNotFoundException | IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("서버 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
    }

    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<String> reviewDelete(@PathVariable Long commentId,
                                               @RequestBody Map<String, String> requestData,
                                               BindingResult bindingResult,
                                               Principal principal) {
        
        String email = principal.getName();
        try {
            System.out.println("삭제 컨트롤러+++");
            commentService.commentDelete(commentId, email);
            return new ResponseEntity<>("댓글 삭제 완료.", HttpStatus.OK);
        } 
        catch (UsernameNotFoundException | IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } 
        catch (Exception e) {
            return new ResponseEntity<>("서버 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
