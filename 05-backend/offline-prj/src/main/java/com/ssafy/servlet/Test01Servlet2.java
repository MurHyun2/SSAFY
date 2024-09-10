package com.ssafy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/test02")
public class Test01Servlet2 extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// response.getWriter();
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("	<title>first</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1>안녕하세요! Hello, World!</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}