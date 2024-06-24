package com.keduit.bird.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@ToString
public class BoardImgDTO {


    private Long boardId;
    private Long id;
    private String imgName;
    private String oriImgName;
    private String imgUrl;

    private static ModelMapper modelMapper = new ModelMapper();

    public static BoardImgDTO of(BoardImgDTO boardCommunityImg){
        return modelMapper.map(boardCommunityImg, BoardImgDTO.class);
    }
}
