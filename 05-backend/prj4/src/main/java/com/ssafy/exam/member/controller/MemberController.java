package com.ssafy.exam.member.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.ssafy.exam.member.model.dto.Member;
import com.ssafy.exam.member.model.service.MemberService;
import com.ssafy.exam.member.model.service.MemberServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member")
public class MemberController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private MemberService service = new MemberServiceImpl();

	// HTTP POST 요청을 처리 (회원가입, 로그인)
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// action 파라미터를 통해 어떤 작업을 수행할지 결정
		String action = request.getParameter("action");

		switch (action) {
		case "register":
			register(request, response);
			break;
		case "login":
			login(request, response);
			break;
		default:
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
			break;
		}
	}

	// HTTP GET 요청을 처리 (로그아웃)
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("logout".equals(action)) {
			logout(request, response);
		} else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
		}
	}

	// 회원가입 처리 메서드
	private void register(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String id = request.getParameter("id");
	    String password = request.getParameter("password");
	    String name = request.getParameter("name");
	    String nickName = request.getParameter("nick_name");
	    String phoneNum = request.getParameter("phone");
	    String addrNum = request.getParameter("zip_code");
	    String addBasic = request.getParameter("user_add1");
	    String addrDetail = request.getParameter("user_add2");

	    Member member = new Member(id, password, name, nickName, phoneNum, addrNum, addBasic, addrDetail);

	    try {
	        service.register(member);
	        // 성공 메시지를 세션에 설정
	        request.getSession().setAttribute("resultMessage", "회원가입이 성공적으로 완료되었습니다!");
	        response.sendRedirect(request.getContextPath() + "/board?action=main"); // 회원가입 성공 시 로그인 페이지로 이동
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // 실패 시 에러 메시지를 세션에 설정
	        request.getSession().setAttribute("resultMessage", "회원가입에 실패하였습니다. 다시 시도해주세요.");
	        response.sendRedirect(request.getContextPath() + "/board?action=main"); // 회원가입 실패 시 다시 회원가입 페이지로 이동
	    }
	}

	// 로그인 처리 메서드
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		try {
			Member member = service.login(id, password);
			if (member != null) {
				// 로그인 성공 시 세션에 회원 정보를 저장
				HttpSession session = request.getSession();
				session.setAttribute("member", member);

				// 로그인 성공 메시지를 세션에 저장
				session.setAttribute("resultMessage", "환영합니다, " + member.getName() + "님!");
				response.sendRedirect(request.getContextPath() + "/board?action=main"); // 메인 페이지로 이동
			} else {
				// 로그인 실패 메시지를 세션에 저장
				HttpSession session = request.getSession();
				session.setAttribute("resultMessage", "아이디 또는 비밀번호가 틀립니다.");
				response.sendRedirect(request.getContextPath() + "/board?action=main"); // 메인 페이지로 이동
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// 서버 오류 메시지를 세션에 저장
			HttpSession session = request.getSession();
			session.setAttribute("resultMessage", "서버 오류가 발생했습니다. 다시 시도해 주세요.");
			response.sendRedirect(request.getContextPath() + "/board?action=main"); // 메인 페이지로 이동
		}
	}

	// 로그아웃 처리 메서드
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate(); // 세션 무효화
		response.sendRedirect(request.getContextPath() + "/board?action=main"); // 로그아웃 후 로그인 페이지로 이동
	}
}
