package com.example.boot11.dto;


import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("fileDto") // Mapper xml 에서 FileDto type 을 간단히 줄여서 쓸수있도록 별칭 부여하기
@Builder
@AllArgsConstructor	
@NoArgsConstructor 
@Data 
public class FileDto {
	private int num;
	private String writer;
	private String title;
	//원본 파일명
	private String orgFileName;
	//파일 시스템에 저장된 파일명
	private String saveFileName;
	//파일의 크기 
	private long fileSize;
	private String regdate;
	//페이징 처리를 위한 필드
	private int startRowNum;
	private int endRowNum;
	//파일 업로드 처리를 하기 위한 필드
	private MultipartFile myFile;   //필기 <input type="file" name="myFile"> 이 떠올라야함	
		
}
