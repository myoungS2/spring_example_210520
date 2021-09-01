package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.NewUserBO;
import com.example.lesson04.model.NewUser;

@RequestMapping("/lesson04")
@Controller
public class NewUserController {
	
	// BO 연결
	@Autowired
	private NewUserBO newUserBO;
	
	// 요청 URL : http://localhost:8080/lesson04/ex01/1
	@RequestMapping(method = RequestMethod.GET, path = "/ex01/1") // GET만 허용하겠다.
	// @GetMapping("/ex01/1") // GET만 허용하겠다.
	public String ex01_1() {
		return "lesson04/addUser"; // jsp 경로 (회원가입창)
	}
	
	// 요청 URL : http://localhost:8080/lesson04/ex01/add_user
	// @RequestMapping(path = "/ex01/add_user", method = RequestMethod.POST) // POST만 허용하겠다.(이 주소를 직접 치고 들어가면-> 405번 에러발생)
	@PostMapping("/ex01/add_user") // POST만 허용하겠다.(이 주소를 직접 치고 들어가면-> 405번 에러발생)
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value="instoduce", required=false) String introduce) {
		
		// DB Insert
		newUserBO.addNewUser(name, yyyymmdd, email, introduce);

		
		return "lesson04/afterAddUser";  // 새로운 view로 넘기기 -> 회원가입이 완료 됨
	}
	
	// 요청 URL : http://localhost:8080/lesson04/ex01/last_user -> 유저의 정보를 table로 뿌려주기(view)
	@GetMapping("/ex01/last_user")
	public String getLastUser(Model model)/* model=NewUser와는 다른 것..! */ {
		// 마지막에 가입된 사람 하나의 정보를 가지고 온다. select DB
		NewUser user = newUserBO.getLastNewUser();
		
		// jsp로 값을 넘기기
		model.addAttribute("user", user); // user라는 키로 데이터를 꺼내올 수 있게 됨, 어떤 값을 넣을 거냐
		model.addAttribute("title", "회원 정보"); // title이라는 키로 데이터를 꺼내면, "회원정보" 를 가져옴
		
		return "lesson04/lastUser";  // jsp 경로 (회원정보table)
	}
}
