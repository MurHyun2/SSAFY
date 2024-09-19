package com.ssafy.ws.step2.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.ssafy.ws.step2.dto.Movie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");

		if ("regist".equals(action)) {
			doRegist(req, resp);
		}
	}

	private void doRegist(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String title = req.getParameter("title");
		String director = req.getParameter("director");
		String genre = req.getParameter("genre");
		int runningTime = Integer.parseInt(req.getParameter("runningTime"));

		Movie movie = new Movie(1, title, director, genre, runningTime);

		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter writer = resp.getWriter();
		
		writer.println("""
				<html>
					<head><title>영화정보</title></head>
					<body>
						<h2>영화정보</h2>
						<p>%s</p>
					</body>
				</html>
					
				""".formatted(movie));
		writer.close();
	}
}
