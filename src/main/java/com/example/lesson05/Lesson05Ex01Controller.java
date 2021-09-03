package com.example.lesson05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller // view페이지로 보낼것이므로 일반controller
public class Lesson05Ex01Controller {

	// 요청 url : http://localhost:8080/lesson05/ex01
	@RequestMapping("/ex01")
	public String ex01() /* view 보낼것이니까 String */ {
		return "lesson05/ex01"; // jsp
	}
}
