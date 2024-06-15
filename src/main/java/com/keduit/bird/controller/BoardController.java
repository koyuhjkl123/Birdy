package com.keduit.bird.controller;

import com.keduit.bird.constant.Role;
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

    @GetMapping("/insertForm")
    public String saveForm(Principal principal){
        String email = principal.getName();
        Member member = memberRepository.findByMemberEmail(email);
        if(member == null){
//           만약에 시큐리티에서도 했지만 한번 더 확인
            return "/members/login";
        }
        if(member.getRole().equals(Role.STOP)){
//           정지된 사람도 다시 로그인 페이지로 이동
            return "/members/login";
        }
        return "save";
    }
    //작성자를 해당 유저의 이름으로 자동적용시키기위해 코드 추가함.

    @PostMapping("/save")
    public String save(@RequestParam("boardTitle") String title,
                       @RequestParam("boardContent") String content,
                       @RequestParam("boardImgFile") List<MultipartFile> imgFiles,
                       Principal principal) throws Exception{
    String email = principal.getName();
    Member member = memberRepository.findByMemberEmail(email);
    if (member == null) {
        System.out.println("데이터베이스에 없는 회원입니다.");
        return "redirect:/board/list";
    }
    BoardDTO boardDTO = new BoardDTO();
    boardDTO.setBoardTitle(title);
    boardDTO.setBoardContent(content);
    boardDTO.setEmail(email);
    boardService.insertBoard(boardDTO, imgFiles, email);

    return "redirect:/board/list";
}

    @GetMapping({"/list","list/{page}"})
    public String boardList(Model model){
        List<BoardDTO> boardDTOList = boardService.getBoardList();
        model.addAttribute("boardList",boardDTOList);
        return "paging";
    }

}
