package com.example.boot11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.example.boot11.repository.UserDao;

public class FileServiceimpl implements FileService{

	@Autowired private UserDao dao;
	
	@Override
	public void getList(Model model) {
	
		
		
	}

}
