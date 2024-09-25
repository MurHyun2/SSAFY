package com.ssafy.exam.main.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainColtroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// main.jsp 페이지로 이동하자..
		// forward vs redirect 방식의 이동
		// forward -> Request 객체 이용
		// redirect -> Response 객체 이용
		// 1. forward 방식 이용하기 - 동일한 프로젝트내의 페이지로 이동 
		// 						- RequestDispatcher 객체를 얻기 (forwarding 할 수 있는 기능이 있음 -> 객체.forward 메서드 호출)
		//						- ContextRoot Path 경로는 제외(/board-step01-mvc/main.jsp) -> (/main.jsp)o
//		RequestDispatcher rd = req.getRequestDispatcher("/main.jsp");
//		rd.forward(req, resp);
		
		// 2. redirect 방식 - 응답객체의 sendRedirect 메서드를 이용
		//					- 다른 프로젝트, 타 사이트로 이동이 가능
		//					- 호출된 서블릿의 주소가 유지되지 않고 리다이렉트 된 페이지의 주소로 변경된다.
		//					- 요청이 2번 발생한다.
		//					- 요청시 만들어진 req 객체가 다르기 때문에 req에 등록된 정보를 사용할 수 없다.
		// 					- 응답코드를 302번으로 설정, Location 헤더의 값으로 페이지 주소를 넘겨준다.
//		resp.sendRedirect("/board-step01-mvc/main.jsp");
		resp.sendRedirect("main.jsp");
	}
}
