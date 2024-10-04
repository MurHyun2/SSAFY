package com.ssafy.exam.inquiry.controller;

import com.ssafy.exam.inquiry.model.dto.Inquiry;
import com.ssafy.exam.inquiry.model.service.InquiryService;
import com.ssafy.exam.inquiry.model.service.InquiryServiceImpl;
import com.ssafy.exam.member.model.dto.Member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = { "/inquiry" })
public class InquiryController extends HttpServlet {
	private InquiryService inquiryService;

	@Override
	public void init() throws ServletException {
		this.inquiryService = new InquiryServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			if ("view".equals(action)) {
				showInquiry(request, response);
			} else if ("list".equals(action) || action == null) {
				listInquiries(request, response);
			} else {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
			}
		} catch (SQLException e) {
			// SQLException을 catch하여 ServletException으로 변환하여 던짐
			throw new ServletException("데이터베이스 처리 중 오류가 발생했습니다.", e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String action = request.getParameter("action");

	    try {
	        // 로그인 상태 체크
	        if (isLoggedIn(request)) {
	            if ("create".equals(action)) {
	                createInquiry(request, response);
	            } else if ("delete".equals(action)) {
	                deleteInquiry(request, response);
	            } else if ("update".equals(action)) {
	                updateInquiry(request, response);
	            } else {
	                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
	            }
	        } else {
	            // 로그인이 필요한 기능일 경우 로그인 페이지로 이동 또는 예외 처리
	            response.sendRedirect(request.getContextPath() + "/main.jsp?error=login_required");
	        }
	    } catch (SQLException e) {
	        // SQLException 발생 시 처리할 내용
	        e.printStackTrace();  // 콘솔에 예외 메시지 출력
	        throw new ServletException("SQL 처리 중 오류가 발생했습니다.", e);  // ServletException으로 감싸서 예외 전파
	    }
	}

	private boolean isLoggedIn(HttpServletRequest request) {
	    HttpSession session = request.getSession();
	    Object memberId = session.getAttribute("memberId");
	    Object memberObj = session.getAttribute("member");

	    if (memberId == null && memberObj != null) {
	        // 세션에 memberId가 없지만 member 객체가 있는 경우, member 객체에서 memberId를 가져와 세션에 저장
	        Member member = (Member) memberObj;
	        session.setAttribute("memberId", member.getId());
	        memberId = member.getId();
	    }

	    return memberId != null && !memberId.toString().trim().isEmpty();
	}



	private void listInquiries(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		try {
			List<Inquiry> inquiries = inquiryService.getAllInquiries();
			request.getSession().setAttribute("inquiryList", inquiries);
			request.getRequestDispatcher("/board?action=main").forward(request, response);
		} catch (SQLException e) {
			// SQLException을 catch하여 ServletException으로 변환하여 던짐
			throw new ServletException("문의 목록 조회 중 오류가 발생했습니다.", e);
		}
	}

	private void showInquiry(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		try {
			int inquiryId = Integer.parseInt(request.getParameter("inquiryId"));
			Inquiry inquiry = inquiryService.getInquiryById(inquiryId);
			request.getSession().setAttribute("selectedInquiry", inquiry);
			request.getRequestDispatcher("/board?action=main").forward(request, response);
		} catch (SQLException e) {
			// SQLException을 catch하여 ServletException으로 변환하여 던짐
			throw new ServletException("문의 조회 중 오류가 발생했습니다.", e);
		}
	}

	private void createInquiry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();
	    String memberId = (String) session.getAttribute("memberId");


	    if (memberId == null || memberId.trim().isEmpty()) {
	        throw new ServletException("회원 ID가 세션에 없습니다. 문의를 작성하기 위해서는 로그인 상태여야 합니다.");
	    }

	    // 요청 파라미터에서 제목과 메시지 값을 가져옴
	    String title = request.getParameter("title");
	    String message = request.getParameter("message");

	    // 제목과 메시지 값 확인을 위한 로그 출력

	    if (title == null || title.trim().isEmpty() || message == null || message.trim().isEmpty()) {
	        session.setAttribute("inquiryErrorMessage", "문의 작성에 실패했습니다. 제목과 내용을 모두 입력해 주세요.");
	        response.sendRedirect(request.getContextPath() + "/board?action=main");
	        return;
	    }

	    // Inquiry 객체 생성 및 데이터 설정
	    Inquiry inquiry = new Inquiry();
	    inquiry.setMemberId(memberId);
	    inquiry.setTitle(title);
	    inquiry.setMessage(message);
	    inquiry.setStatus("대기 중");


	    try {
	        // 데이터베이스에 문의 정보 저장
	        inquiryService.createInquiry(inquiry);

	        session.setAttribute("inquirySuccessMessage", "문의가 성공적으로 등록되었습니다!");
	        response.sendRedirect(request.getContextPath() + "/inquiry?action=list");
	    } catch (SQLException e) {
	        e.printStackTrace();
	        session.setAttribute("inquiryErrorMessage", "문의 등록 중 오류가 발생했습니다. 다시 시도해 주세요.");
	        response.sendRedirect(request.getContextPath() + "/board?action=main");
	    }
	}




	private void deleteInquiry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    HttpSession session = request.getSession();
	    String loggedInMemberId = (String) session.getAttribute("memberId");
	    int inquiryId = Integer.parseInt(request.getParameter("inquiryId"));

	    // 삭제할 문의의 작성자 확인
	    Inquiry inquiry = inquiryService.getInquiryById(inquiryId);

	    // 요청을 보낸 사용자가 작성자일 때만 삭제 허용
	    if (inquiry != null && inquiry.getMemberId().equals(loggedInMemberId)) {
	        inquiryService.deleteInquiry(inquiryId);
	        response.sendRedirect(request.getContextPath() + "/inquiry?action=list");
	    } else {
	        // 작성자가 아니면 오류 페이지 또는 메시지 표시
	        response.sendRedirect(request.getContextPath() + "/main.jsp?error=unauthorized");
	    }
	}


	private void updateInquiry(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int inquiryId = Integer.parseInt(request.getParameter("inquiryId"));
			String title = request.getParameter("title");
			String message = request.getParameter("message");
			String status = request.getParameter("status");

			Inquiry inquiry = new Inquiry();
			inquiry.setInquiryId(inquiryId);
			inquiry.setTitle(title);
			inquiry.setMessage(message);
			inquiry.setStatus(status);

			inquiryService.updateInquiry(inquiry);
			response.sendRedirect(request.getContextPath() + "/inquiry?action=view&inquiryId=" + inquiryId);
		} catch (SQLException e) {
			throw new ServletException("문의 수정 중 오류가 발생했습니다.", e);
		}
	}
}
