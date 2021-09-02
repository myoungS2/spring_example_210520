package com.example.lesson04.dao;

import org.springframework.stereotype.Repository;

import com.example.lesson04.model.NewStudent;

@Repository
public interface NewStudentDAO {
	
	public int insertNewStudent(NewStudent newstudent);
	
	public NewStudent selectNewStudentById(int id);
}
