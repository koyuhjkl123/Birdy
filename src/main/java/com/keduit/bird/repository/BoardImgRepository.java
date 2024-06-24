package com.keduit.bird.repository;

import com.keduit.bird.entity.BoardImg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardImgRepository extends JpaRepository<BoardImg, Long> {

    BoardImg findByBoardId(Long boardid);
    BoardImg findByBoardNoticeId(Long boardNoticeId);
}
