package com.example.lesson04.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson04.model.NewUser;

@Repository
public interface NewUserDAO {
	
	// INSERT
	public int insertNewUser(
			@Param("name") String name,
			@Param("yyyymmdd") String yyyymmdd,
			@Param("email") String email,
			@Param("introduce") String introduce);
	
	public NewUser selectLastNewUser();
	
	// lesson06 ex02
	public boolean existNewUserByName(String name);
}
