package com.keduit.bird.dto;

import com.keduit.bird.entity.Board;
import com.keduit.bird.entity.BoardImg;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO extends Board {

    private Long id;
    private String email; //
    private String boardTitle;
    private String boardContent;
    private int boardHits;//조회수
    private List<MultipartFile> boardFile; //save.html->Controller 파일담는용도
    private List<String> originalFileName; //원본 파일이름
    private List<String> storedFileName;//서버 저장용 파일이름
    private int fileAttached; //파일 첨부 여부(첨부 1, 미첨부 0)


    public BoardDTO(Long id, String email, String boardTitle,  int boardHits, LocalDateTime boardCreatedTime) {
        this.id = id;
        this.email = email;
        this.boardTitle = boardTitle;
        this.boardHits = boardHits;
    }

    public static BoardDTO toBoardDTO(Board boardEntity){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(boardEntity.getId());
        boardDTO.setEmail(boardEntity.getAdminBoardId());
        boardDTO.setBoardContent(boardEntity.getBoardContent());
        boardDTO.setBoardTitle(boardEntity.getBoardTitle());
        boardDTO.setBoardHits(boardEntity.getBoardHits());
        if (boardEntity.getFileAttached() == 0){
            boardDTO.setFileAttached(boardEntity.getFileAttached());//0
        }else {
            List<String> originalFileNameList = new ArrayList<>();
            List<String> storedFileNameList = new ArrayList<>();
            boardDTO.setFileAttached((boardEntity.getFileAttached()));//1
            for(BoardImg boardFileEntity: boardEntity.getBoardFileEntityList()) {
                originalFileNameList.add(boardFileEntity.getOriginalFileName());
                storedFileNameList.add(boardFileEntity.getOriginalFileName());
            }
            boardDTO.setOriginalFileName(originalFileNameList);
            boardDTO.setStoredFileName(storedFileNameList);
//            //파일 이름 가져가기_ 단일 파일 코드
//            // orginalFileName, storedFileName : board_file_table(BoardFileEntity)
//            // join
//            // select * from board_table b, board_file_table bf where b.id=bf.board_id
//            // and where b.id=?
//            boardDTO.setOriginalFileName(boardEntity.getBoardFileEntityList().get(0).getOriginalFileName());
//            boardDTO.setStoredFileName(boardEntity.getBoardFileEntityList().get(0).getStoredFileName());
            }

        return boardDTO;

    }
}
