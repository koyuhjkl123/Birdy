package com.keduit.bird.entity;

import com.keduit.bird.dto.BoardDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Board extends BaseEntity{
    @Id//pk
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    Member member;
    //이걸 작성자 = memberName으로 삼기.
    private String boardTitle;
    private String boardContent;
    private int count;
    public void updateCommunity(BoardDTO boardCommunityFormDTO){
        this.id = boardCommunityFormDTO.getId();
        this.boardTitle = boardCommunityFormDTO.getBoardTitle();
        this.boardContent = boardCommunityFormDTO.getBoardContent();
    }
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<BoardImg> boardImgs = new ArrayList<>();


}
