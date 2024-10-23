package com.ssafy.mvc.controller;

import org.eclipse.tags.shaded.org.apache.regexp.recompile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.UserService;

import jakarta.servlet.http.HttpSession;



@Controller
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@GetMapping("login")
	public String loginForm() {
		return "user/loginform";
	}
	
	@PostMapping("login")
	public String login(@ModelAttribute User user, HttpSession session) {
		User tmp = userService.login(user.getId(), user.getPassword());
		if(tmp == null) {
			return "redirect:login";
		}
		session.setAttribute("loginUser", tmp.getName());
		return "redirect:list";
	}
	
	@GetMapping("users")
	public String userList(Model model) {
		model.addAttribute("userList", userService.getUserList());
		return "user/adminPage";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:list";
	}
	
	@GetMapping("signup")
	public String signupForm() {
		return "user/signupform";
	}
	
	@PostMapping("signup")
	public String signup(User user) {
		userService.signup(user);
		return "redirect:list";
	}
	
}
