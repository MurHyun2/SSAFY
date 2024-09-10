package com.ssafy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private Map<String, String> members = new HashMap<>();

	public LoginServlet() {
		members.put("ssafy", "ssafy");
		members.put("admin", "admin");
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login Servlet called");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String ID = request.getParameter("id");
		String PW = request.getParameter("pw");

		
		String result = "로그인 실패!";
		String pass = members.get(ID);
		
		if(pass != null) {
			if(PW.equals(pass)) {
				result = "로그인 성공!";
			}
		}
		
		out.print("""
				<html>
					<head><title>Pr</title><head>
					<body>
						<h2>아이디 : %s</h2>
						<h2>비밀번호 : %s</h2>
						<h2>결과 : %s</h2>
					</body>
				</html>
				""".formatted(ID, PW, result));
	}
}
