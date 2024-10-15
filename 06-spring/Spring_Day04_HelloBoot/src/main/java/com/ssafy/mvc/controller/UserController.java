package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mvc.model.dto.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	// 정석 Service를 의존성 주입 받아야 한다.!

//	@Autowired
//	private final UserService userService;
//	
////	@Autowired
////	public void setUserService(UserService userService) {
////		this.userService = userService;
////	}
//	
//	@Autowired
//	public UserController(UserService userService) {
//		this.userService = UserService;
//	}

	@GetMapping("/login")
	public String loginForm() {
		return "/user/loginForm";
	}

//	@PostMapping("/login")
//	public String loginForm(@RequestParam("id") String id, @RequestParam("pw") String pw) {
//		System.out.println(id);
//		System.out.println(pw);
//		return "redirect:hello";
//	}

	@PostMapping("/login")
	public String loginForm(@ModelAttribute User user, HttpSession session) {
		System.out.println(user);
		// 세션에 저장
		session.setAttribute("loginUser", user.getId());
		
		return "redirect:hello";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// 방법 1. loginUser만 지우기
		session.removeAttribute("loginUser");
		// 방법 2. 세션 지우기
		session.invalidate();
		System.out.println("LOGOUT!");
		
		return "redirect:hello";
	}
}
