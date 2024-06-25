package com.keduit.bird.dto;

import com.keduit.bird.entity.Board;
import lombok.*;

import java.time.LocalDateTime;

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
    private String fileName;


    public BoardDTO(Long id, String boardTitle, String nickName, LocalDateTime regTime, int count) {
        this.id = id;
        this.boardTitle = boardTitle;
        this.nickName = nickName;
        this.regTime = regTime;
        this.count = count;
    }


    public BoardDTO() {

    }

    public static BoardDTO toBoard(Board board){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(board.getId());
        boardDTO.setBoardTitle(board.getBoardTitle());
        boardDTO.setBoardContent(board.getBoardContent());

        return boardDTO;
    }

}
