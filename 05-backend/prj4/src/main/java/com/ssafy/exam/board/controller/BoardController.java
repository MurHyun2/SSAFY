package com.ssafy.exam.board.controller;

import java.io.IOException;

import com.ssafy.exam.board.model.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		switch (action) {
		case "main":
			doMain(req,resp);
			break;

		}
	}

	private void doMain(HttpServletRequest req, HttpServletResponse resp) {
		
		
	}
	
}
