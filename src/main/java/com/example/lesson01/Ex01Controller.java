package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
@RequestMapping("/lesson01/ex01") // lesson01/ex01 공통으로 사용
@Controller
public class Ex01Controller {
	
	// String 출력하기
	// 요청 URL : http://localhost/lesson01/ex01/1
	@RequestMapping("/1") // 항상 슬래시부터 시작한다..!(예외x)   // 주소 매핑
	@ResponseBody // 메소드가 리턴하는 값(type)을 여기에 담아서 보내겠다. (메소드당 한개씩 있어야함) 
	// 리턴되는 값을 HTML Response Body로 보낸다.
	public String PringtString() {
		String text = "예제 1번 <br> 문자열을 response body로 보내는 예제";
		return text;
	}
	
	// 요청 URL : http://localhost/lesson01/ex01/2
	@RequestMapping("/2")
	public @ResponseBody Map<String, Object> pringMap(){
		// {"키"=값}
		Map<String, Object> map = new HashMap<>();
		map.put("apple", 4);
		map.put("banana", 45468654);
		map.put("pineapple", 55995);
		map.put("grape", 68);
		
		// MessageConverter
		return map;
		// map을 리턴하면 json으로 나타난다.(web starter에 jackson 이라는 라이브러리가 포함되어있기 때문)
	}
}
