package com.ssafy.exam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardDAO boardDao;

	public BoardController() {
		boardDao = BoardDAO.getInstance();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");

		switch (action) {
		case "list": {
			list(req, resp);
			break;
		}
		case "writeForm": {
			writeForm(req, resp);
			break;
		}
		case "write": {
			write(req, resp);
			break;
		}
		}
	}

	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Board> list = boardDao.selectBoardList();
		System.out.println(list);
		
		req.setAttribute("list", list);

		RequestDispatcher rd = req.getRequestDispatcher("/board/list.jsp");
		rd.forward(req, resp);
	}

	private void writeForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/board/writeForm.jsp");
		rd.forward(req, resp);
	}

	private void write(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");

		Board board = new Board();

		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		board.setViews(0);
		boardDao.insertBoard(board);

		resp.sendRedirect("/board-step01-mvc/board?action=list");
	}
}