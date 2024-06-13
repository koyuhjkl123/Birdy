package com.keduit.bird.service;

import com.keduit.bird.dto.BoardDTO;
import com.keduit.bird.entity.Board;
import com.keduit.bird.entity.BoardImg;
import com.keduit.bird.repository.BoardFileRepository;
import com.keduit.bird.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardFileRepository boardFileRepository;
    private final MemberService memberService;

    public void save(BoardDTO boardDTO,String email) throws IOException {
        //파일 첨부 여부에 따라서 로직을 분리
        if(){}
        if (boardDTO.getBoardFile().isEmpty()) {
            //첨부 파일 없음.
            String memberName = getMemberNameFromAuthentication();
            Board boardEntity = Board.toSaveEntity(boardDTO, memberName);
            boardRepository.save(boardEntity);
        } else {
            //첨부파일 있음.
            // 첨부 파일 있음.
            /*
                1. DTO에 담긴 파일을 꺼냄
                2. 파일의 이름 가져옴
                3. 서버 저장용 이름을 만듦
                // 내사진.jpg => 839798375892_내사진.jpg
                4. 저장 경로 설정
                5. 해당 경로에 파일 저장
                6. board_table에 해당 데이터 save 처리
                7. board_file_table에 해당 데이터 save 처리
             */
            String memberName = getMemberNameFromAuthentication();
            Board boardEntity = Board.toSaveFileEntity(boardDTO, memberName);
            Long savedId = boardRepository.save(boardEntity).getId();
            Board board = boardRepository.findById(savedId).get();
            for (MultipartFile boardFile : boardDTO.getBoardFile()) {
//                MultipartFile boardFile = boardDTO.getBoardFile(); // 1.다중파일일경우 필요없는 부분
                String originalFilename = boardFile.getOriginalFilename(); // 2.
                String storedFileName = originalFilename; // 3.
                String savePath = "C:/pj/members/" + storedFileName; // 4. 윈도우경로는 C:/springboot_img/ 그리고 9802398403948_내사진.jpg
                boardFile.transferTo(new File(savePath)); // 5.

                BoardImg boardFileEntity = BoardImg.toBoardFileEntity(board, originalFilename, storedFileName);
                boardFileRepository.save(boardFileEntity);
            }
        }
    }

    @Transactional
    public List<BoardDTO> findAll() {
        List<Board> boardEntityList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for (Board boardEntity : boardEntityList) {
            boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
        }
        return boardDTOList;
    }

    @Transactional
    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    @Transactional
    public BoardDTO findById(Long id) {
        Optional<Board> optionalBoardEntity = boardRepository.findById(id);
        if (optionalBoardEntity.isPresent()) {
            Board boardEntity = optionalBoardEntity.get();
            BoardDTO boardDTO = BoardDTO.toBoardDTO(boardEntity);
            return boardDTO;
        } else {
            return null;
        }
    }

    public BoardDTO update(BoardDTO boardDTO) {
        String memberName = getMemberNameFromAuthentication();
        Board boardEntity = Board.toUpdateEntity(boardDTO, memberName);
        boardRepository.save(boardEntity);

        return findById(boardDTO.getId());
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }

    public Page<BoardDTO> paging(Pageable pageable) {
        int page = pageable.getPageNumber() - 1; //page 위치에 있는 값은 0부터 시작
        int pageLimit = 3; //한페이지에 보여줄 글 개수
        Page<Board> boardEntities =
                boardRepository.findAll(PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.DESC, "id")));

        System.out.println("boardEntities.getContent() = " + boardEntities.getContent()); // 요청 페이지에 해당하는 글
        System.out.println("boardEntities.getTotalElements() = " + boardEntities.getTotalElements()); // 전체 글갯수
        System.out.println("boardEntities.getNumber() = " + boardEntities.getNumber()); // DB로 요청한 페이지 번호
        System.out.println("boardEntities.getTotalPages() = " + boardEntities.getTotalPages()); // 전체 페이지 갯수
        System.out.println("boardEntities.getSize() = " + boardEntities.getSize()); // 한 페이지에 보여지는 글 갯수
        System.out.println("boardEntities.hasPrevious() = " + boardEntities.hasPrevious()); // 이전 페이지 존재 여부
        System.out.println("boardEntities.isFirst() = " + boardEntities.isFirst()); // 첫 페이지 여부
        System.out.println("boardEntities.isLast() = " + boardEntities.isLast()); // 마지막 페이지 여부

        // 목록: id, writer, title, hits, createdTime + 작성자: memberEmail
        Page<BoardDTO> boardDTOS = boardEntities.map(board -> new BoardDTO(board.getId(), board.getAdminBoardId(),
                board.getBoardTitle(), board.getBoardHits(), board.getBoardCreatedTime()));
        return boardDTOS;
    }

    // Authentication 객체를 사용하여 현재 사용자의 이름을 가져오는 메서드(게시판 작성자)
    public String getMemberNameFromAuthentication() {
        String memberEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        String memberName = memberService.findMemberNameByMemberEmail(memberEmail);
        return memberName;
    }
    //작성자 컬럼 찾아오기.
    public List<BoardDTO> findByAdminBoardId(String adminBoardId){
        List<Board> boardEntityList = boardRepository.findByAdminBoardId(adminBoardId);
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for (Board boardEntity : boardEntityList) {
            boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
        }
        return boardDTOList;
    }
}
