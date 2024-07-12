package com.example.boot00.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.boot00.dto.PostDto;

@Controller
public class PostController {
	
	@ResponseBody
	@GetMapping("/posts")
	public List<PostDto> posts(){
		
		List<PostDto> posts=new ArrayList<>();
		posts.add(new PostDto(1, "김구라", "노량진"));
		posts.add(new PostDto(2, "해골", "행신동"));
		posts.add(new PostDto(3, "원숭이", "동물원"));
		// List<MemberDto> 객체를 리턴하면 [{},{},{},...] 형식의 JSON 문자열이 응답된다.
		return posts;
	}
	

	
	@ResponseBody
	@GetMapping("/posts/1")
	public PostDto posts2() {
		PostDto dto=new PostDto();
		dto.setNum(1);
		dto.setName("김구라");
		dto.setTitle("가나다");
		return dto;
	}
	
	
	/*
	 *  @ResponseBody 어노테이션이 붙어 있는 메소드에서 Map 객체를 리턴하면
	 *  Map 에 담긴 정보가 JSON 문자열로 변환되어서 클라이언트에게 응답된다.
	 */
	@ResponseBody
	@PostMapping("/posts3")
	public Map<String, Object> posts3(){
		//DB 에서 읽어온 회원 한명의 정보라고 가정하자 
		Map<String, Object> map=new HashMap<>();
		map.put("num", 1);
		map.put("name", "김구라");
		map.put("isMan", true);
		
		return map;
	}
	
	
	}
	
	
