package com.keduit.bird.controller;

import com.keduit.bird.dto.BoardDTO;
import com.keduit.bird.dto.CommentDTO;
import com.keduit.bird.entity.Member;
import com.keduit.bird.repository.MemberRepository;
import com.keduit.bird.service.BoardService;
import com.keduit.bird.service.CommentService;
import com.keduit.bird.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    private final CommentService commentService;
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @GetMapping("/save")
    public String saveForm(Principal principal, Model model){
//        String memberEmail = principal.getName();
//        String adminBoardId = memberService.findMemberNameByMemberEmail(memberEmail);
//        model.addAttribute("adminBoardId", adminBoardId);
        return "save";
    }
    //작성자를 해당 유저의 이름으로 자동적용시키기위해 코드 추가함.

    @PostMapping("/save")
    public String save(@RequestParam Map<String, String> requestData,
                       @RequestParam("boardImgFile") List<MultipartFile> imgFiles,
                       BindingResult bindingResult, Principal principal) throws Exception {
        String email = principal.getName();
        Member member = memberRepository.findByMemberEmail(email);
        if (member == null) {
            System.out.println("데이터베이스에 없는 회원입니다.");
            return "redirect:/board/list";
        }
        if (bindingResult.hasErrors()) {
            System.out.println("에러발생 -+-++" + bindingResult.getAllErrors());
            return "redirect:/board/list";
        }
        String title = requestData.get("title");
        String content = requestData.get("content");

        System.out.println("제목+++++++++" + title);
        System.out.println("내용+++++++++" + content);
        System.out.println("업로드된 이미지 수+++++++++" + imgFiles.size());

        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBoardTitle(title);
        boardDTO.setBoardContent(content);
        boardService.insertBoard(boardDTO, imgFiles, email);

        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public String boardList(Model model){
        List<BoardDTO> boardDTOList = boardService.getBoardList();
        model.addAttribute("boardList",boardDTOList);
        return "paging";
    }


}
