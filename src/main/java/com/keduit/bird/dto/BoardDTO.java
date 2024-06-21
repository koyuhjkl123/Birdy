package com.keduit.bird.dto;

import com.keduit.bird.entity.Board;
import com.keduit.bird.entity.BoardImg;
import com.keduit.bird.entity.Member;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class BoardDTO {

    private Long id;
    private String email; //
    private String boardTitle;
    private String boardContent;
    private LocalDateTime regTime;
    private LocalDateTime updateTime;
    private int count;//조회수
    private String nickName;
    private String imgUrl;
    private String oriImgName;
    private boolean deleteImg; 

    public BoardDTO(Long id, String boardTitle, String nickName, LocalDateTime regTime, int count) {
        this.id = id;
        this.boardTitle = boardTitle;
        this.nickName = nickName;
        this.regTime = regTime;
        this.count = count;
    }


    public BoardDTO() {

    }
}
