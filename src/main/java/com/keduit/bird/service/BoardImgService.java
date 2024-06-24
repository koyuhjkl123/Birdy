package com.keduit.bird.service;

import com.keduit.bird.entity.BoardImg;
import com.keduit.bird.repository.BoardImgRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
// java의 롬복이 데려오기
public class BoardImgService {


    @Value("${profileLocation}")
    private String profileLocation;
    private final FileService fileService;
    private final BoardImgRepository boardImgRepository;

    public void saveCommunityImg(BoardImg BoardImg, MultipartFile multipartFile) throws Exception{
        String oriImgName = multipartFile.getOriginalFilename();
        String imgName = "";
        String imgUrl = "";

        if(!StringUtils.isEmpty(oriImgName)){
            imgName = fileService.uploadFile(profileLocation,oriImgName, multipartFile.getBytes());
            imgUrl = "C:/pj/members/" +imgName;
        }
        BoardImg.updateBoardImg(oriImgName,imgName,imgUrl);
        boardImgRepository.save(BoardImg);
    }

    public String uploadFile(String uploadPath, String originalFileName,
                             byte[] fileData) throws Exception{
        UUID uuid = UUID.randomUUID();
        // ID 랜덤 생성(Universally Unique Identifier) = 고유의 식별자 만들기
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        // 확장자 만들기
        String saveFileName = uuid.toString() + extension;
        // 랜덤 ID.확장자 형식으로 만듬.
        String fileUploadFillUrl = uploadPath + "/" + saveFileName;
        // 파일의 실제 경로와 / ID + 확장자를 붙여 풀 네임을 표시
        FileOutputStream fos = new FileOutputStream(fileUploadFillUrl);
        // FileOutputStream : 파일에 바이트 단위로 데이터를 쓰기 위한 클래스
        fos.write(fileData);
        // 읽어내기
        fos.close();
        // 닫기 필요!
        return saveFileName;
    }




}
