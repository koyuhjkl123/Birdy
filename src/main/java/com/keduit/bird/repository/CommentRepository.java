package com.keduit.bird.repository;

import com.keduit.bird.entity.Board;
import com.keduit.bird.entity.BoardComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<BoardComment, Long> {
    // select * from comment_table where board_id=? order by id desc;
    List<BoardComment> findAllByBoardEntityOrderByIdDesc(Board boardEntity);
}
