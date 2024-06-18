package com.keduit.bird.controller;

import com.keduit.bird.dto.CommentDTO;
import com.keduit.bird.service.CommentService;
import com.keduit.bird.repository.CommentRepository;
import com.keduit.bird.entity.BoardComment;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/insert/{eventId}")
    public String reviewWrite(@PathVariable Long eventId,
                              @RequestBody Map<String, String> requestData,
                              Principal principal) {

        String review = requestData.get("review");
        System.out.println("review테스트: " + review);
        commentService.insertReview(review, eventId, principal.getName());
        return "redirect:/schedule/" + eventId;
    }

    @PutMapping("/update/{reviewId}")
    public ResponseEntity<Long> reviewUpdate(@PathVariable Long reviewId,
                                             @RequestBody Map<String, String> requestData,
                                             BindingResult bindingResult,
                                             Principal principal) {

        System.out.println("컨트롤러 들옴..!!");
        Long reviewno = Long.parseLong(requestData.get("reviewId"));
        String review = requestData.get("review");
        String email = principal.getName();
        if (!bindingResult.hasErrors()) {
            BoardReview boardReview = commentRepository.findByReviewNo(reviewno);
            commentService.updateReview(reviewno, email, review);
            return ResponseEntity.ok().body(boardReview.getReviewNo());
        }

        return ResponseEntity.badRequest().body(null);
    }

    @DeleteMapping("/user/review/delete/{reviewId}")
    public ResponseEntity<Long> reviewDelete(@PathVariable Long reviewId,
                                             @RequestBody Map<String, String> requestData,
                                             BindingResult bindingResult,
                                             Principal principal) {

        Long reviewno = Long.parseLong(requestData.get("reviewId"));
        String email = principal.getName();
        if (!bindingResult.hasErrors()) {
            BoardReview boardReview = commentRepository.findByReviewNo(reviewno);
            commentService.deleteReview(reviewno, email);
            return ResponseEntity.ok().body(boardReview.getReviewNo());
        }

        return ResponseEntity.badRequest().body(null);
    }
}
