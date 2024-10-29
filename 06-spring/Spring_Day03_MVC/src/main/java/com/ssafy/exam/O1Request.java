/*
	사용자 요청 -> 서버 응답
	백엔드 @WebServlet("/주소"), class
	스프링 @RequestMapping("/주소") class, method
		  @GetMapping("/주소"), @PostMapping("/주소") : method
		  
	파라미터 받기
	백엔드 request.getParameter("~~");
	스프링 request.getParameter("~~");
	@ReqeustParam,
	@RequestParam Map
	
	DTO 객체
	~~
	
	공유 처리
	백엔드 : request.setAttribute(~~);
	스프링 : ??
	
	페이지 이동
	백엔드 : forward, redirect
	스프링 : ~~
*/
package com.ssafy.exam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/request")
public class O1Request {

	public O1Request() {
		// TODO Auto-generated constructor stub
		System.out.println("01Request Called");
	}

	@RequestMapping("/test1")
	public String test01() {
		System.out.println("test1 called");
		return "redirect:/01request.jsp";
	}

	@RequestMapping("/test2")
	public String test02() {
		System.out.println("test2 called");
		return "redirect:/01request.jsp";
	}

//	@RequestMapping(value = "/test3")
	@RequestMapping("/test3")
	public String test03() {
		System.out.println("test3 called");
		return "redirect:/01request.jsp";
	}

	@RequestMapping(path = "/test4")
	public String test04() {
		System.out.println("test4 called");
		return "redirect:/01request.jsp";
	}

	// 배열로도 가능
	@RequestMapping(path = { "/test5-1", "/test5-2" })
	public String test05() {
		System.out.println("test5 called");
		return "redirect:/01request.jsp";
	}

	@RequestMapping(value = "/test6", method = RequestMethod.GET)
	public String test06() {
		System.out.println("test6 called");
		return "redirect:/01request.jsp";
	}
	
	@RequestMapping(value = "/test7", method = RequestMethod.POST)
	public String test07() {
		System.out.println("test7 called");
		return "redirect:/01request.jsp";
	}
	
	@GetMapping("/test8")
	public String test08() {
		System.out.println("test8 called");
		return "redirect:/01request.jsp";
	}
	
	@PostMapping("/test9")
	public String test09() {
		System.out.println("test9 called");
		return "redirect:/01request.jsp";
	}
}
