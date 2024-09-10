package com.ssafy.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

// Servlet Class를 호출할 수 있게 주소 설정
// Servlet의 주소 설정시 "/"로 시작하게 만들자.. 안만들면 문제 발생(확자자 패턴 제외)

@WebServlet("/test01")
public class Test01Servlet extends MyServlet {
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("### Call Service Method ###");
	}
	// 실행시 호출되는 메서드 : Tomcat Server에 의해서 자동으로 호출

}
