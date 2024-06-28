package com.keduit.bird.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import com.keduit.bird.entity.BoardNotice;

public interface BoardNoticeRepository extends JpaRepository<BoardNotice, Long>  {


    Page<BoardNotice> findByBoardTitleContaining(@RequestParam("keyword") String keyword, Pageable pageable);

    Page<BoardNotice> findByBoardContentContaining(@RequestParam("keyword") String keyword, Pageable pageable);

    @Query("SELECT b FROM BoardNotice b WHERE b.boardTitle LIKE %:keyword% OR b.boardContent LIKE %:keyword%")
    Page<BoardNotice> findFilterBoard(@Param("keyword") String keyword, Pageable pageable);

    @Query("SELECT b FROM BoardNotice b JOIN b.member m WHERE m.memberName LIKE %:memberName%")
    Page<BoardNotice> findByMemberNameContaining(@Param("memberName") String memberName, Pageable pageable);

    @Query(value = "SELECT * FROM Board_Notice ORDER BY id DESC LIMIT 3", nativeQuery = true)
    List<BoardNotice> findTop3ByIdDesc();

    

}
