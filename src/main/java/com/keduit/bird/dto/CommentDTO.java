package com.keduit.bird.dto;

import com.keduit.bird.entity.BoardComment;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CommentDTO {
    private Long id;
    private String email;
    private String nickName;
    private String commentContents;
    private Long boardId;
    private LocalDateTime regTime;
    private LocalDateTime updateTime;

}