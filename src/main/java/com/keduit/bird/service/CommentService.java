package com.keduit.bird.service;

import com.keduit.bird.dto.CommentDTO;
import com.keduit.bird.entity.Board;
import com.keduit.bird.entity.BoardComment;
import com.keduit.bird.repository.BoardRepository;
import com.keduit.bird.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;



}