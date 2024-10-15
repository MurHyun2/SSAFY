package com.ssafy.selfexam.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.selfexam.dto.User;

@Controller
@RequestMapping("share")
public class O4Share {
	
	@GetMapping("index")
	public void index() {}
	
	//매개변수의 클래스 정보가 자동으로 등록 
//	@GetMapping("test1")
//	public String test1(User user) {
//		return "share/index";
//	}
	
	@GetMapping("test1")
	public String test1(@ModelAttribute("u") User user) {
		return "share/index";
	}
	
	@GetMapping("test2")
	public String test2(Model model) {
		model.addAttribute("msg", "공유 1");
		model.addAttribute("hello", "하이!");
		return "share/index";
	}
	
	@GetMapping("test3")
	public String test2(Map<String, String> map) {
		map.put("mapMsg", "공유 1");
		map.put("mapHello", "하이!");
		return "share/index";
	}
}
