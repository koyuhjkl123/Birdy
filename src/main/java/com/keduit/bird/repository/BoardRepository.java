package com.keduit.bird.repository;

import com.keduit.bird.entity.Board;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Page<Board> findByBoardTitleContaining(@RequestParam("keyword") String keyword, Pageable pageable);

    Page<Board> findByBoardContentContaining(@RequestParam("keyword") String keyword, Pageable pageable);

    @Query("SELECT b FROM Board b WHERE b.boardTitle LIKE %:keyword% OR b.boardContent LIKE %:keyword%")
    Page<Board> findFilterBoard(@Param("keyword") String keyword, Pageable pageable);

    @Query("SELECT b FROM Board b JOIN b.member m WHERE m.memberName LIKE %:memberName%")
    Page<Board> findByMemberNameContaining(@Param("memberName") String memberName, Pageable pageable);

    @Query("SELECT b FROM Board b WHERE b.member.memberName = :memberName")
    List<Board> findByMemberName(@Param("memberName") String memberName);



}
