package com.example.boot11.repository;

import java.util.List;

import com.example.boot11.dto.FileDto;

public interface FileDao {
	public List<FileDto> getList();
	public FileDto getData(int id);
	public void insert(FileDto dto);
	public void upload(FileDto dto);
	public void download(FileDto dto);
	public void delete(int id);
	//저장할 글번호를 미리 얻어내서 리턴하는 메소드
	public int getSequence();
}
