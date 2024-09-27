package com.ssafy.board.controller;

import java.io.IOException;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.board.model.service.BoardServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService service = BoardServiceImpl.getInstance();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");

		switch (action) {
		case "writeForm":
			doWriteForm(req, resp);
			break;
		case "write":
			doWrite(req, resp);
			break;
		case "list":
			doList(req, resp);
			break;
		case "detail":
			doDetail(req, resp);
			break;
		case "delete":
			doRemove(req, resp);
			break;
		case "updateForm":
			doUpdateForm(req, resp);
			break;
		case "update":
			doUpdate(req, resp);
			break;
		}
	}

	private void doUpdateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		Board board = service.getBoard(id);
		req.setAttribute("board", board);

		req.getRequestDispatcher("/WEB-INF/board/updateForm.jsp").forward(req, resp);
		;
	}

	private void doUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");

		Board board = service.getBoard(id);
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		service.modifyBoard(board);

		resp.sendRedirect("board?action=detail&id=" + id);
	}

	private void doRemove(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		service.removeBoard(id);
		resp.sendRedirect("board?action=list");

	}

	private void doDetail(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, NumberFormatException {
		int id = Integer.parseInt(req.getParameter("id"));

		req.setAttribute("board", service.getBoard(id));
		req.getRequestDispatcher("/WEB-INF/board/detail.jsp").forward(req, resp);
	}

	private void doList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("list", service.getList());
		req.getRequestDispatcher("/WEB-INF/board/list.jsp").forward(req, resp);
	}

	private void doWrite(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");

		Board board = new Board(title, writer, content);

		service.writeBoard(board);

		resp.sendRedirect("board?action=list");

	}

	private void doWriteForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/board/writeForm.jsp").forward(req, resp);
	}
}
