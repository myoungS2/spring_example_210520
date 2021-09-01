package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.dao.NewUserDAO;
import com.example.lesson04.model.NewUser;

@Service
public class NewUserBO {
	
	// dao 연결
	@Autowired
	private NewUserDAO newUserDAO;
	
	// INSERT
	public void addNewUser (
			String name, String yyyymmdd, String email, String introduce) {
		newUserDAO.insertNewUser(name, yyyymmdd, email, introduce);
	}
	
	public NewUser getLastNewUser() {
		return newUserDAO.selectLastNewUser();
	}
}
