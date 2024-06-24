package com.keduit.bird.entity;

import com.keduit.bird.dto.BoardNoticeDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class BoardNotice extends BaseEntity{
    @Id//pk
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;


    //이걸 작성자 = memberName으로 삼기.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    Member member;

    private String boardTitle;
    private String boardContent;
    private int count;
    public void updateCommunity(BoardNoticeDTO boardNoticeDTO){
        this.id = boardNoticeDTO.getId();
        this.boardTitle = boardNoticeDTO.getBoardTitle();
        this.boardContent = boardNoticeDTO.getBoardContent();
    }
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<BoardImg> boardImgs = new ArrayList<>();
}
