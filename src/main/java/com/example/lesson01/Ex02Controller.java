package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // view 리턴
public class Ex02Controller {
	
	// 요청URL : http://localhost/lesson01/ex02
	@RequestMapping("/lesson01/ex02")
	public String ex02() {
		// 1. @Controller 어노테이션만 있을 때 (@ResponseBody가 없음)
		// 2. ViewResolver 클래스 작동 -> 3. 리턴 된 String 이름의 view를 찾아서 view화면이 구성된다.
		
		return "lesson01/ex02"; // view위치에 따른 경로( / 안붙이기!) /WEB-INF/jsp/lesson01/ex02.jsp (풀경로)
	}
}
