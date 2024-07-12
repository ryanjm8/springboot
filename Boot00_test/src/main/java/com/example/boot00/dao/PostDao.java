package com.example.boot00.dao;

import java.util.List;
import com.example.boot00.dto.PostDto;

public interface PostDao {
	public List<PostDto> getList();
	public void insert(PostDto dto);
	public void delete(int num);
	public PostDto getData(int num);
	public void update(PostDto dto);
}
