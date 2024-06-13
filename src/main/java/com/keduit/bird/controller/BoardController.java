package com.keduit.bird.controller;

import com.keduit.bird.dto.BoardDTO;
import com.keduit.bird.dto.CommentDTO;
import com.keduit.bird.service.BoardService;
import com.keduit.bird.service.CommentService;
import com.keduit.bird.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    private final CommentService commentService;
    private final MemberService memberService;

    @GetMapping("/save")
    public String saveForm(Principal principal, Model model){
//        String memberEmail = principal.getName();
//        String adminBoardId = memberService.findMemberNameByMemberEmail(memberEmail);
//        model.addAttribute("adminBoardId", adminBoardId);
        return "save";
    }
    //작성자를 해당 유저의 이름으로 자동적용시키기위해 코드 추가함.
    @PostMapping("/save")
    public String save(@Valid BoardDTO boardDTO, @RequestParam("boardImgFile")List<MultipartFile> boardImgFileList, Principal principal) throws Exception {

        System.out.println("포스팅 왔음");
        String email = principal.getName();
        System.out.println("boardDTO = " + boardDTO);
        boardDTO.setEmail(email);
        boardService.saveBoard(boardDTO,boardImgFileList,email);
        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public String boardList(Model model){
        List<BoardDTO> boardDTOList = boardService.getBoardList();
        model.addAttribute("boardList",boardDTOList);
        return "paging";
    }


}
