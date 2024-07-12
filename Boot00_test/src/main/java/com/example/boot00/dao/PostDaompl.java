package com.example.boot00.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.boot00.dto.PostDto;


@Repository
public class PostDaompl implements PostDao{
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<PostDto> getList() {
		
		List<PostDto> list= session.selectList("post.getList");
		
		return list;
	}

	@Override
	public void insert(PostDto dto) {
		
		session.insert("post.insert", dto);
	}

	@Override
	public void delete(int num) {
		
		session.delete("post.delete", num);
	}

	@Override
	public PostDto getData(int num) {
		
		PostDto dto=session.selectOne("post.getdata", num);
		
		return dto;
	}

	@Override
	public void update(PostDto dto) {
		
		session.update("post.updaate", dto);
		
	}

}
