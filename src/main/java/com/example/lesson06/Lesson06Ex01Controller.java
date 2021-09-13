package com.example.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.NewUserBO;

@RequestMapping("lesson06/ex01")
@Controller
public class Lesson06Ex01Controller {
	
	// bo 연결
	@Autowired
	private NewUserBO newUserBO;
	
	// 요청 url : http://localhost:8080/lesson06/ex01/add_user_view
	// 유저 추가 화면
	@RequestMapping("/add_user_view")
	public String addUserView() {
		return "lesson06/addUser"; // input jsp
	}
	
	@ResponseBody // ajax
	@PostMapping("/add_user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value="email", required=false) String email,
			@RequestParam(value="introduce", required=false) String introduce) {
		
		// insert DB
		newUserBO.addNewUser(name, yyyymmdd, email, introduce);
		
		// return "lesson06/afterAddUser" ;// input 성공 후 보여질 jsp
		return "success"; // ajax -> 결과 String
	}
	
	@RequestMapping("/after_add_user")
	public String afterAddUser() {
		return "lesson06/afterAddUser";
	}
}
