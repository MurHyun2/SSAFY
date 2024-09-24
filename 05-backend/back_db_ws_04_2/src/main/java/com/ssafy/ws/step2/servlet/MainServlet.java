package com.ssafy.ws.step2.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.ws.step2.dto.Movie;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/movie")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Movie> list = new ArrayList<>();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");

		switch (action) {
		case "regist":
			regist(req, resp);
			break;
		case "regist_result":
			regist_result(req, resp);
			break;
		case "list":
			list(req, resp);
			break;
		}
	}

	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("list", list);
		
		RequestDispatcher rd = req.getRequestDispatcher("/list.jsp");
		rd.forward(req, resp);
	}

	private void regist_result(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		Movie movie = null;
		
		for (Movie m : list) {
			if(m.getId() == id) {
				movie = m;
				break;
			}
		}
		
		req.setAttribute("movie", movie);
		
		RequestDispatcher rd = req.getRequestDispatcher("/regist_result.jsp");
		rd.forward(req, resp);
	}

	private void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = list.isEmpty() ? 1 : list.size() + 1;
		
		String title = req.getParameter("title");
		String director = req.getParameter("director");
		String genre = req.getParameter("genre");
		int runningTime = Integer.parseInt(req.getParameter("runningTime"));
		
		Movie movie = new Movie(id, title, director, genre, runningTime);
		list.add(movie);

		resp.sendRedirect(req.getContextPath() + "/movie?action=regist_result&id=" + id);
	}
}
