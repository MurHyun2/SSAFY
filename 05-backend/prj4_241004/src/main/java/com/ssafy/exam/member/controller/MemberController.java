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
		case "delete":
			delete(request, response);
			break;
		case "update":
			update(request, response);
			break;
		default:
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
			break;
		}
	}

	// 회원정보 수정 메서드
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String nickName = request.getParameter("nick_name");
		String phoneNum = request.getParameter("phone");
		String addrNum = request.getParameter("zip_code");
		String addrBasic = request.getParameter("user_add1");
		String addrDetail = request.getParameter("user_add2");

		Member member = new Member();
		member.setId(id);
		member.setName(name);
		member.setNickName(nickName);
		member.setPhoneNum(phoneNum);
		member.setAddrNum(addrNum);
		member.setAddrBasic(addrBasic);
		member.setAddrDetail(addrDetail);

		try {
			service.modifyMember(member);

			// 세션에서 기존 회원 정보 가져오기
			HttpSession session = request.getSession();
			Member sessionMember = (Member) session.getAttribute("member");

			// 세션의 회원 객체를 업데이트된 정보로 교체
			sessionMember.setName(name);
			sessionMember.setNickName(nickName);
			sessionMember.setPhoneNum(phoneNum);
			sessionMember.setAddrNum(addrNum);
			sessionMember.setAddrBasic(addrBasic);
			sessionMember.setAddrDetail(addrDetail);

			// 비밀번호 유지
			sessionMember.setPassword(sessionMember.getPassword());

			// 세션에 업데이트된 객체를 다시 저장
			session.setAttribute("member", sessionMember);

			// 성공 메시지와 함께 리다이렉트
			session.setAttribute("resultMessage", "회원정보 수정이 성공적으로 완료되었습니다!");
			response.sendRedirect(request.getContextPath() + "/board?action=main");
		} catch (SQLException e) {
			e.printStackTrace();
			// 실패 시 에러 메시지를 세션에 설정
			request.getSession().setAttribute("resultMessage", "회원정보 수정이 실패하였습니다. 다시 시도해주세요.");
			response.sendRedirect(request.getContextPath() + "/board?action=main");
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
		String addrBasic = request.getParameter("user_add1");
		String addrDetail = request.getParameter("user_add2");

		Member member = new Member(id, password, name, nickName, phoneNum, addrNum, addrBasic, addrDetail);

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

	// 회원탈퇴
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");

		if (member != null) {
			String memberId = member.getId(); // 세션에서 회원 ID를 가져옴
			try {
				service.deleteMember(memberId);
				session.setAttribute("resultMessage", "회원 탈퇴가 성공적으로 완료되었습니다.");
				session.invalidate(); // 세션 무효화 (로그아웃 처리)
				response.sendRedirect(request.getContextPath() + "/board?action=main"); // 메인 페이지로 이동 경로 수정
			} catch (SQLException e) {
				// 예외 발생 시 오류 메시지를 출력하고, 에러 페이지로 이동
				e.printStackTrace();
				request.setAttribute("resultMessage", "회원 탈퇴 중 오류가 발생했습니다: " + e.getMessage());
				request.getRequestDispatcher(request.getContextPath() + "/board?action=main").forward(request,
						response);
			}
		} else {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "로그인이 필요합니다.");
		}
	}
}
