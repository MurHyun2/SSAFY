package com.ssafy.selfexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("pagemove")
public class O3PageMove {
	
	// ModelAndView는 객체와 주소를 같이 반환할때 사용하면 좋다
	@GetMapping("index")
	public ModelAndView index() {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("msg", "Hi SPRING BOOT!");
//		mav.setViewName("pagemove/index");
//		return mav;
		
		return new ModelAndView("pagemove/index", "msg", "Hi SPRING BOOT!");
	}
	
	// 반환타입이 void라면 주소값이 반환값으로 넘어간다. @GetMapping("index") -> index
//	@GetMapping("index")
//	public void index() {
//	}

//	@GetMapping("index")
//	public String index() {
//		return "pagemove/index";
//	}
}
