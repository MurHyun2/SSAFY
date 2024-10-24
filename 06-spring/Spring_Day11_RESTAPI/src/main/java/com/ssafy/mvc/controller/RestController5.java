package com.ssafy.mvc.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.User;

@RestController
@RequestMapping("/rest5")
public class RestController5 {
	
	// 폼 데이터 형식으로 넘어올때
	@PostMapping("/board1")
	public String test1(@ModelAttribute User user) {
		return user.toString();
	}
	
	// 클라이언트가 넘길 데이터가 JSON 형태라면 알아서 넣어주기 위해서 @RequestBoard를 사용
	@PostMapping("/board2")
	public String test2(@RequestBody User user) {
		return user.toString();
	}
	
	
}