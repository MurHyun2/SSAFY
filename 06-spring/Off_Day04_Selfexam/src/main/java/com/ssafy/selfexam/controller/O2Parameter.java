package com.ssafy.selfexam.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.selfexam.dto.User;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("param")
public class O2Parameter {

	@GetMapping("index")
	public String index() {
		return "param/index";
	}

	@GetMapping("test1")
	public String test1(HttpServletRequest req) {
		String id = req.getParameter("id");
		String pw = req.getParameter("pass");
		System.out.println("HttpServletRequest : " + id + " " + pw);

		return "param/index";
	}

	@GetMapping("test2")
	public String test2(@RequestParam String id, @RequestParam(value="pass") String pw, @RequestParam(required = false) String name,
			@RequestParam(defaultValue = "default@email.com") String email) {
		System.out.println("@RequestParam : " + id + ", " + pw + ", " + name + ", " + email);

		return "param/index";
	}
	
	@GetMapping("test3")
	public String test3(@RequestParam Map<String, String> map) {
		System.out.println(map);
		
		return "param/index";
	}
	
	@GetMapping("test4")
	public String test4(User user) {
		System.out.println(user);
		
		return "param/index";
	}
}
