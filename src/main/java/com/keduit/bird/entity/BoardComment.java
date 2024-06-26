package com.keduit.bird.entity;



import com.keduit.bird.dto.CommentDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class BoardComment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String content;
    /* Board:Comment = 1:N */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;


    public static BoardComment toSaveEntity(CommentDTO commentDTO) {
        BoardComment commentEntity = new BoardComment();
        commentEntity.setEmail(commentDTO.getEmail());
        commentEntity.setContent(commentDTO.getCommentContents());
        return commentEntity;
    }

    // nickName=memberName 을 가져오는 메서드 추가
    public String getMemberName() {
        if (this.board != null && this.board.getMember() != null) {
            return this.board.getMember().getMemberName();
        }
        return null;
    }
}
