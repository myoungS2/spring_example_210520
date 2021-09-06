package com.example.lesson05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson05Ex02Controller {
	@RequestMapping("/lesson05/ex02")
	public String ex02(Model model){
		// List<String>
		List<String> fruits = new ArrayList<>();
		fruits.add("파인애플");
		fruits.add("복숭아");
		fruits.add("메론");
		fruits.add("포도");
		fruits.add("망고");
		
		model.addAttribute("fruits", fruits);
		
		// List<Map>
		List<Map<String, Object>> users = new ArrayList<>();
		// [{1}, {2}]
		
		Map<String, Object> map = new HashMap<>(); // 1
		map.put("name", "심미영");
		map.put("age", 25);
		map.put("hobby", "독서");
		users.add(map);
		
		map = new HashMap<>(); // 2 (heap에 새로운 영역)
		map.put("name", "신바다");
		map.put("age", 3);
		map.put("hobby", "스크래쳐");
		users.add(map);
		
		model.addAttribute("users", users);
		
		return "lesson05/ex02"; // jsp
	}
}
