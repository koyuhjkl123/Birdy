package com.keduit.bird.service;


import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Service
public class FileService {
    public String uploadFile(String uploadPath, String originalFileName,
                             byte[] fileData) throws Exception{

        UUID uuid = UUID.randomUUID();
        // Universally Unique Identifier: 범용 고유 식별자를 의미하며 중복이 되지 않는 유일한 값을 구성하고자 할때 사용
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String saveFileName = uuid.toString() + extension;
        String fileUploadFullUrl = uploadPath + "/" + saveFileName;
        FileOutputStream fos = new FileOutputStream(fileUploadFullUrl);
        fos.write(fileData);
        fos.close();
        return saveFileName;
    }

    public void deleteFile(String filePath) throws Exception{
//  저장된 파일의 경로를 이용하여 파일객체를 생성.
        File deleteFile = new File(filePath);
//   해당 파일이 있으면 삭제
        if(deleteFile.exists()){
            deleteFile.delete();
            System.out.println("파일 삭제 완료");
        }else {
            System.out.println("파일 삭제 실패");

        }
    }
}