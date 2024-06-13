package com.keduit.bird.repository;

import com.keduit.bird.dto.BoardDTO;
import com.keduit.bird.entity.BoardEntity;
import com.keduit.bird.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    @Modifying
    @Query(value = "update BoardEntity b set b.boardHits=b.boardHits+1 where b.id=:id")
    void updateHits(@Param("id") Long id);

    @Query("SELECT m.memberName FROM Member m WHERE m.memberEmail = :memberEmail")
    Optional<String> findMemberNameByMemberEmail(@Param("memberEmail") String memberEmail);
    //principal 을 통해 memberEmail 을 가져온다(getName)

    List<BoardEntity> findByAdminBoardId(String adminBoardId);

}


