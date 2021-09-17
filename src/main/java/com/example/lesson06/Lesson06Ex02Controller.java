package com.example.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.NewUserBO;

@RequestMapping("/lesson06/ex02")
@Controller
public class Lesson06Ex02Controller {
	
	@Autowired
	private NewUserBO newUserBO;
	
	// localhost:8080/lesson06/ex02/add_name_view
	
	@RequestMapping("/add_name_view")
	public String addNameView() {
		return "lesson06/addName";
	}
	
	@RequestMapping("/is_duplication")
	@ResponseBody // 데이터를 내려줄 때는 반드시..!!!!!!
	public Map<String, Boolean> isDuplication(
			@RequestParam("name") String name) {
		
		// select DB -> name
		newUserBO.existNewUserByName(name);
		
		
		Map<String, Boolean> result = new HashMap<>();  // true -> 중복
		result.put("is_duplication", newUserBO.existNewUserByName(name));
		
		return result;
	}
}
