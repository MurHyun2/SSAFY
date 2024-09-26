package com.ssafy.exam.board.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.exam.board.model.dao.BoardDAOImpl;
import com.ssafy.exam.board.model.dto.Board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardDAOImpl boardDao;

	public BoardController() {
		boardDao = BoardDAOImpl.getInstance();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");

		switch (action) {
		case "list":
			try {
				list(req, resp);
			} catch (ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
			break;
		case "writeForm":
			writeForm(req, resp);
			break;
		case "write":
			try {
				write(req, resp);
			} catch (ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
			break;
		case "detail":
			try {
				detail(req, resp);
			} catch (ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
			break;
		case "delete":
			try {
				delete(req, resp);
			} catch (ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
			break;
		case "updateForm":
			try {
				updateForm(req, resp);
			} catch (ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
			break;
		case "update":
			try {
				update(req, resp);
			} catch (ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
			break;
		}
	}

	private void updateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		int no = Integer.parseInt(req.getParameter("no"));
		Board board = boardDao.selectBoard(no);

		req.setAttribute("board", board);
		
		RequestDispatcher rd = req.getRequestDispatcher("/board/update.jsp");
		rd.forward(req, resp);
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		int no = Integer.parseInt(req.getParameter("no"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		boardDao.updateBoard(no, title, content);

		resp.sendRedirect(req.getContextPath() + "/board?action=detail&no=" + no);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		int no = Integer.parseInt(req.getParameter("no"));
		boardDao.deleteBoard(no);

		resp.sendRedirect(req.getContextPath() + "/board?action=list");
	}

	private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		int no = Integer.parseInt(req.getParameter("no"));
		
		boardDao.updateViewCnt(no);
		
		Board board = boardDao.selectBoard(no);
		req.setAttribute("board", board);

		RequestDispatcher rd = req.getRequestDispatcher("/board/detail.jsp");
		rd.forward(req, resp);
	}

	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		List<Board> list = boardDao.selectBoardList();

		req.setAttribute("list", list);

		RequestDispatcher rd = req.getRequestDispatcher("/board/list.jsp");
		rd.forward(req, resp);
	}

	private void writeForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/board/write.jsp");
		req.getCookies();
		rd.forward(req, resp);
	}

	private void write(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");

		Board board = new Board();

		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		boardDao.insertBoard(board);

		resp.sendRedirect(req.getContextPath() + "/board?action=list");
	}
}