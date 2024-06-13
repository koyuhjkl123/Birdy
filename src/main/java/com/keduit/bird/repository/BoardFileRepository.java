package com.keduit.bird.repository;

import com.keduit.bird.entity.BoardImg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardFileRepository extends JpaRepository<BoardImg, Long> {

}
