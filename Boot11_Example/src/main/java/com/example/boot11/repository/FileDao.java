package com.example.boot11.repository;


import java.util.List;



import com.example.boot11.dto.FileDto;

public interface FileDao {	
	public void insert(FileDto dto);  //파일정보 저장
	public FileDto getData(int num);  //파일하나의 정보 리턴하기
	public void delete(int num);	  //파일하나의 정보 삭제하기
	public List<FileDto> getList();   //파일 전체 목록 불러오기	
	public int getCount(); //전체 글의 갯수를 리턴하는 메소드
}
