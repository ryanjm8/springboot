package com.example.boot10.controller;

import java.util.List;

import org.apache.catalina.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot10.dao.PostDao;
import com.example.boot10.dto.PostDto;
import com.example.boot10.service.PostService;

@RestController	// @ResponseBody 의 기능이 모든 메소드에 포함된다.
public class PostController {
	//dao 객체를 주입 받아서
	//@Autowired 
	//private PostDao dao;
	
	//필요한 서비스객체를 interface DI 받는다
	@Autowired private PostService service;

	@GetMapping("/posts")
	public List<PostDto> getList(){
		//글 전체 목록을 서비스 객체를 이용해서 얻어온다음
		List<PostDto> list=service.getAll();
		//리턴해준다
		return list;
	}
	/*
	@PostMapping("/posts")
	public PostDto insert(String title, String author) {
		// @Builder 의 기능을 이용해서 PostDto 객체에 데이터를 담으면서 객체의 참조값 얻어내기 
		PostDto dto = PostDto.builder().title(title).author(author).build();
		//dao 를 이용해서 dto 에 저장된 정보를 DB 에 저장하기 
		dao.insert(dto);
		//현재 추가된 정보를 리턴하기 
		return dto;
	}
	*/
	
	//위의 요청 파라미터 추출을 좀더 편한 방법으로 하면 아래와 같다
	@PostMapping("/posts")
	public PostDto insert(PostDto dto) { // title 과 author 가 추출되어서 PostDto 객체에 담긴채로 전달된다.
		//서비스를 이용해서 글을 저장하고 리턴해주는 PostDto 를 컨트롤러에서 리턴해준다.
		return service.addContent(dto);
	}
	
	@GetMapping("/posts/{id}")
	public PostDto getData(@PathVariable("id") int id) {
		//서비스를 이용해서 글하나의 정보를 얻어와서 리턴해 준다.
		return service.getContent(id);
	}
	
	@DeleteMapping("/posts/{id}")
	public PostDto delete(@PathVariable("id") int id) {
		//서비스를 이용해서 글을 삭제하고 리턴되는 글정보를 리턴한다.
		return service.removeContent(id);
	}
	
	@PutMapping("/posts/{id}")
	public PostDto update(@PathVariable("id") int id, PostDto dto) {
		//PostDto 에 경로 변수로 넘어오는 수정할 글번호도 담아서 
		dto.setId(id);
		//서비스를 이용해서 수정한다
		service.updateContent(dto);
		//수정된 데이터를 리턴해준다
		return dto;
	}
}
