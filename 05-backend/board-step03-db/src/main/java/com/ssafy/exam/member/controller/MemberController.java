package com.ssafy.exam.member.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.ssafy.exam.member.dao.MemberDAOImpl;
import com.ssafy.exam.member.dto.Member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberDAOImpl memberDao;

	public MemberController() {
		memberDao = MemberDAOImpl.getInstance();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");

		switch (action) {
		case "signUp":
			try {
				signUp(req, resp);
			} catch (ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
			break;
		case "signUpForm":
			signUpForm(req, resp);
			break;
		case "signIn":
			try {
				signIn(req, resp);
			} catch (ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
			break;
		case "signInForm":
			signInForm(req, resp);
			break;
		case "signOut":
			signOut(req, resp);
			break;
		}
	}

	private void signOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		resp.sendRedirect(req.getContextPath() + "/main");
	}

	private void signInForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/member/signIn.jsp");
		rd.forward(req, resp);
	}

	private void signIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		String id = req.getParameter("id");
		String password = req.getParameter("pw");
		Member param = new Member();
		param.setId(id);
		param.setPw(password);
		Member member = memberDao.selectSignIn(param);

		String path = "/member?action=signInForm";

		if (member != null) {
			path = "/main";
			HttpSession session = req.getSession();
			session.setAttribute("memberInfo", member);
		}
		
		Cookie cookie = new Cookie(member.getId(), member.getName());

		cookie.setMaxAge(600);
		cookie.setHttpOnly(true);
		cookie.setPath("/");
		resp.addCookie(cookie);

		resp.sendRedirect(req.getContextPath() + path);
	}

	private void signUpForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/member/signUp.jsp");
		rd.forward(req, resp);
	}

	/**
	 * 회원가입 처리
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException 
	 */
	private void signUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String password = req.getParameter("pw");

		Member member = new Member(id, name, password);
		memberDao.insertMember(member);

		resp.sendRedirect(req.getContextPath() + "/member?action=signInForm");
	}
}
