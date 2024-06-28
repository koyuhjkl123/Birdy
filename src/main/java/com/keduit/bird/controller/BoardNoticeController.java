package com.keduit.bird.controller;

import com.keduit.bird.constant.Role;
import com.keduit.bird.dto.BoardDTO;
import com.keduit.bird.dto.BoardNoticeDTO;
import com.keduit.bird.entity.BoardNotice;
import com.keduit.bird.entity.Member;
import com.keduit.bird.repository.MemberRepository;
import com.keduit.bird.service.BoardNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;
import java.util.Map;



@Controller
@RequiredArgsConstructor
@RequestMapping("/notice")
public class BoardNoticeController {



    private final BoardNoticeService boardNoticeService;
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
        return "notice/save";
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
    BoardNoticeDTO boardDTO = new BoardNoticeDTO();
    boardDTO.setBoardTitle(title);
    boardDTO.setBoardContent(content);
    boardDTO.setEmail(email);
    try {
        boardNoticeService.insertBoard(boardDTO, imgFiles, email);
    } catch (Exception e) {
        System.out.println("게시물을 저장하는 중 오류가 발생했습니다: " + e.getMessage());
        return new ResponseEntity<>("게시물을 저장하는 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return new ResponseEntity<>("게시물이 성공적으로 저장되었습니다.", HttpStatus.OK);
}



    @GetMapping({"/list","/list/{requestData}"})
    public  String boardList( @RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "10") int size,
                             @RequestParam(required = false) String type,
                             @RequestParam(required = false) String keyword,
                            Model model){
        System.out.println("공지사항페이지 이동 컨트롤러+++");
        String search = "";
        Pageable pageable = PageRequest.of(page, size);
        Page<BoardNotice> boardPage = boardNoticeService.getBoardPage(pageable, type, keyword);

        if ("titleAndContent".equals(type)) {
            search = "제목+내용";
        } 
        if ("title".equals(type)) {
            search = "제목";
        }
        if ("content".equals(type)) {
            search = "내용";
        }
        if ("writer".equals(type)) {
            search = "작성자";
        } 
        model.addAttribute("search", search);
        model.addAttribute("keyword", keyword);
        model.addAttribute("boardPage", boardPage);
        return "notice/paging";
    }
    

    @GetMapping("/{id}")
    public String oneBoard(@PathVariable("id") Long boardId, Model model,
                           HttpServletRequest request, HttpServletResponse response) {
        System.out.println("컨트롤러 왔음 공지사항 ");
        BoardNoticeDTO boardDTO = boardNoticeService.getOneBoard(boardId);

        // Check if the board was visited
        Cookie[] cookies = request.getCookies();
        boolean visited = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                // Check if the visited cookie for the specific boardId exists
                if (cookie.getName().equals("visited_" + boardId)) {
                    visited = true;
                    break;
                }
            }
        }

        // Increase view count if not visited
        if (!visited) {
            boardNoticeService.increaseViewCount(boardId);

            // Set cookie to mark the board as visited
            Cookie cookie = new Cookie("visited_" + boardId, "true");
            cookie.setMaxAge(24 * 60 * 60); // 24 hours
            cookie.setPath("/"); // Cookie is valid for the entire site
            response.addCookie(cookie);
        }

        // Add boardDTO to the model
        model.addAttribute("boardDTO", boardDTO);

        return "notice/detail";
    }



    @GetMapping("update/{boardid}")
    public String boardUpdateForm(@PathVariable("boardid") Long boardId,Model model){

        System.out.println("수정 페이지 이동");
        BoardNoticeDTO boardDTO = boardNoticeService.getOneBoard(boardId);
        model.addAttribute("boardDTO", boardDTO);

        return "notice/update";
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateBoard(@PathVariable Long id,
                                              @ModelAttribute BoardDTO boardDTO,
                                              @RequestParam("boardImgFile") List<MultipartFile> boardImgFile,
                                              Principal principal) {
        System.out.println("수정컨트롤러 도착" + boardDTO.toString());
   // 파일의 사이즈를 출력
        System.out.println("파일 사이즈: " + boardImgFile.get(0).getSize() + " bytes");
        // 파일의 원본 이름을 출력
        System.out.println("원본 파일 이름: " + boardImgFile.get(0).getOriginalFilename());
        // 파일의 콘텐츠 타입을 출력
        System.out.println("파일 콘텐츠 타입: " + boardImgFile.get(0).getContentType());
        
        // 파일의 저장 이름을 출력 (필요하다면)
        System.out.println("파일 저장 이름: " + boardImgFile.get(0).getName());
        // 존재 유무
        System.out.println("비어있는 유무1"+boardImgFile.isEmpty());
        System.out.println("비어있는 유무2"+boardImgFile.get(0).isEmpty());
        String email = principal.getName();
        Member member = memberRepository.findByMemberEmail(email);
        if (member == null) {
            return new ResponseEntity<>("데이터베이스에 없는 회원입니다.", HttpStatus.NOT_FOUND);
        }
        try {
            System.out.println("수정컨트롤러 try");
            boardNoticeService.boardUpdate(boardDTO, boardImgFile, email);
        } catch (Exception e) {
            return new ResponseEntity<>("게시물을 수정하는 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("게시물이 성공적으로 수정되었습니다.", HttpStatus.OK);
    }


    @DeleteMapping("/delete/{boardid}")
    public ResponseEntity<String> boardDelete(@PathVariable("boardid") Long boardId,
                              @RequestBody Map<String, String> requestData,Principal principal){

        try {
            System.out.println("삭제 컨트롤러왔씀");
            System.out.println("삭제 boardId"+boardId);

            String email = principal.getName();
            boardNoticeService.boardDelete(boardId, email);
        } catch (Exception e) {
            // alert에서 뜨는 메세지는 서비스에서 구현
            return new ResponseEntity<>("게시물을 수정하는 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("게시물이 성공적으로 수정되었습니다.", HttpStatus.OK);
    }




}
