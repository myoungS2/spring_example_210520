package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.NewStudentBO;
import com.example.lesson04.model.NewStudent;

@RequestMapping("/lesson04/ex02")
@Controller
public class NewStudentController {
	
	// bo 연결
	@Autowired
	private NewStudentBO newStudentBO;
	
	// url : http://localhost:8080/lesson04/ex02/1
	@GetMapping("/1")
	public String addStudentView() {
		return "lesson04/addStudent"; // jsp
	}
	
	// url : http://localhost:8080/lesson04/ex02/add_student
	@PostMapping("/add_student")
	public String addStudent(
			@ModelAttribute NewStudent newStudent, /* name 태그 값과 일치하는 필드에 값이 들어간다. */
			Model model)  {
		// 학생정보 파라미터 받기
		
		// DB INSERT
		newStudentBO.addNewStudent(newStudent);
		
		// DB SELECT
		NewStudent newStudentModel = newStudentBO.getNewStudentById(newStudent.getId());
		
		// VIEW 데이터 세팅(model)
		
		model.addAttribute("student", newStudentModel); // select가 된 데이터
		
		return "lesson04/afterAddStudent"; 
	}
}
