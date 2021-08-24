package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController // @Controller + ResponseBody
public class Ex01RestController {
	
	// 요청 URL : http://localhost/lesson01/ex01/3
	@RequestMapping("/3")
	// 스프링은 어노테이션을 잘 사용하면 됨..!
	public String printString() {
		return "@RestController를 사용해서 String을 리턴해본다.";
	}
	
	// 요청 URL : http://localhost/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String, String> printMap(){
		Map<String, String> result = new HashMap<>();
		result.put("111","222");
		result.put("333","444");
		result.put("555","666");
		return result;
	}
	
	// 요청 URL : http://localhost/lesson01/ex01/5
	@RequestMapping("/5")
	public Data printData()/*메소드*/ {
		// 일반 자바 bean(객체)
		Data data = new Data(); // 우리가 new 해서 사용하는 것 = java bean
								// @RestController 같이 new 없이 쓰는 것 = spring bean
		data.setId(1);
		data.setName("심미영");
		return data; // 일반 bean 객체도 json으로 내려간다.
	}
	
	@RequestMapping("/6")
	public ResponseEntity<Data> entity(){
		Data data = new Data(); // 일반 자바 bean
		data.setId(100);
		data.setName("신바다");
		return new ResponseEntity<>(data, HttpStatus.OK); // 생성자(리턴하려는 객체, HttpStatus) => 200 ok
//		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR); // 500 error
	}
}
