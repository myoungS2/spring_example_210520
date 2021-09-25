package com.example.marondalgram;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MarondalgramController {
	
	// 1. 로그인 화면
	// 요청 url : localhost:8080/user/sign_in_view
	@RequestMapping("/user/sign_in_view")
	public String sign_in_view() {
		return "marondalgram/signInView";
	}
	
	// 2. 회원가입 화면
	// 요청 url : localhost:8080/user/sign_up_view
	@RequestMapping("/user/sign_up_view")
	public String sign_up_view() {
		return "marondalgram/signUpView";
	}
	
	// 3. 메인화면(timeline)
	// 요청 url : localhost:8080/timeline/list_view
	@RequestMapping("/timeline/list_view")
	public String list_view() {
		return "marondalgram/listView";
	}
	
}
