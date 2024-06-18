package com.keduit.bird.controller;

import com.keduit.bird.constant.Role;
import com.keduit.bird.dto.BoardDTO;
import com.keduit.bird.dto.CommentDTO;
import com.keduit.bird.entity.Board;
import com.keduit.bird.entity.Member;
import com.keduit.bird.repository.MemberRepository;
import com.keduit.bird.service.BoardService;
import com.keduit.bird.service.CommentService;
import com.keduit.bird.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String>  boardInsert(@RequestParam("boardTitle") String title,
                       @RequestParam("boardContent") String content,
                       @RequestParam("boardImgFile") List<MultipartFile> imgFiles,
                       Principal principal) throws Exception{
    String email = principal.getName();
    Member member = memberRepository.findByMemberEmail(email);
    if (member == null) {
        System.out.println("데이터베이스에 없는 회원입니다.");
         return new ResponseEntity<>("데이터베이스에 없는 회원입니다.", HttpStatus.NOT_FOUND);
    }
    BoardDTO boardDTO = new BoardDTO();
    boardDTO.setBoardTitle(title);
    boardDTO.setBoardContent(content);
    boardDTO.setEmail(email);
    try {
        boardService.insertBoard(boardDTO, imgFiles, email);
    } catch (Exception e) {
        System.out.println("게시물을 저장하는 중 오류가 발생했습니다: " + e.getMessage());
        return new ResponseEntity<>("게시물을 저장하는 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return new ResponseEntity<>("게시물이 성공적으로 저장되었습니다.", HttpStatus.OK);
}



    @GetMapping({"/list","/list/{page}"})
    public  String boardList( @RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "10") int size,
                             @RequestParam(required = false) String type,
                             @RequestParam(required = false) String keyword,
                            Model model){
        System.out.println("컨틀로러 도착");
        System.out.println("page"+page);
        System.out.println("size"+size);
        System.out.println("type"+type);
        System.out.println("keyword"+keyword);       
        Pageable pageable = PageRequest.of(page, size);
        Page<Board> boardPage = boardService.getBoardPage(pageable, type, keyword);
        System.out.println("boardPage++"+boardPage.getTotalElements());
        for (Board board : boardPage) {
            System.out.println(board.getBoardContent());
            System.out.println(board.getBoardTitle());
        }
        model.addAttribute("boardPage", boardPage);
        return "paging";
    }

}
