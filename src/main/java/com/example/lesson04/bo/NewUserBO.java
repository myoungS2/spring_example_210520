package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.dao.NewUserDAO;

@Service
public class NewUserBO {
	
	// dao 연결
	@Autowired
	private NewUserDAO newUserDAO;
	
	// INSERT
	public int addNewUser (
			String name, String yyyymmdd, String email, String introduce) {
		return newUserDAO.insertNewUser(name, yyyymmdd, email, introduce);
	}
}
