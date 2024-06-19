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
    public ResponseEntity<String> commentUpate(@PathVariable Long commentId,
                                             @RequestBody Map<String, String> requestData,
                                             BindingResult bindingResult,
                                             Principal principal) {
        try{
            System.out.println("컨트롤러 들옴..!!");
            Long boardId = Long.parseLong(requestData.get("boardId"));
            Board board = boardRepository.findById(boardId).orElse(null);
            String comment = requestData.get("comment");
            String email = principal.getName();
            CommnentDTO boardComment = new CommentDTO();
            boardComment.setId(commentId);
            boardComment.setEmail(email);
            boardComment.setContent(comment);
            boardComment.setBoard(board);
            // System.out.println("boardComment++++"+boardComment.toString());
            commentService.commentUpdate(boardComment);

        }

        catch (Exception e) {
            return new ResponseEntity<>("서버 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        




       

        return ResponseEntity.badRequest().body(null);
    }

    // @DeleteMapping("/user/review/delete/{reviewId}")
    // public ResponseEntity<Long> reviewDelete(@PathVariable Long reviewId,
    //                                          @RequestBody Map<String, String> requestData,
    //                                          BindingResult bindingResult,
    //                                          Principal principal) {

    //     Long reviewno = Long.parseLong(requestData.get("reviewId"));
    //     String email = principal.getName();
    //     if (!bindingResult.hasErrors()) {
    //         BoardReview boardReview = commentRepository.findByReviewNo(reviewno);
    //         commentService.deleteReview(reviewno, email);
    //         return ResponseEntity.ok().body(boardReview.getReviewNo());
    //     }

    //     return ResponseEntity.badRequest().body(null);
    // }
}
