package com.keduit.bird.repository;

import com.keduit.bird.entity.Board;
import com.keduit.bird.entity.BoardComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<BoardComment, Long> {

    List<BoardComment> findByBoardId(Long boardId);

    @Query("SELECT c FROM BoardComment c WHERE c.email = :email")
    List<BoardComment> findByEmail(@Param("email") String email);
    
}
