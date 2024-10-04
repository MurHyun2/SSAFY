package com.ssafy.exam.review.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.exam.member.model.dto.Member;
import com.ssafy.exam.review.model.Review;
import com.ssafy.exam.review.model.service.ReviewService;
import com.ssafy.exam.review.model.service.ReviewServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/review")
public class ReviewController extends HttpServlet {
	private ReviewService reviewService;

	public ReviewController() {
		reviewService = ReviewServiceImpl.getInstance();
	}

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");

		// 리뷰작성 폼 이동
		if ("writeForm".equals(action)) {
			//nickname, videoNo 가져와서 write.jsp로 보내기
			Member member = new Member();
			member = (Member) req.getSession().getAttribute("member");
			String nickName = member.getNickName();
			req.setAttribute("nickName", nickName);
			int videoNo = Integer.parseInt(req.getParameter("videoNo"));
			req.setAttribute("videoNo", videoNo);
			req.getRequestDispatcher("/review/write.jsp").forward(req, res);
		} // 리뷰 수정 폼으로 이동
		else if ("updateForm".equals(action)) {
			 // 리뷰 번호 받기
			int reviewNo = Integer.parseInt(req.getParameter("reviewNo"));
			Review review = new Review();

			try {//받은 리뷰 번호로 수정할 리뷰 가져오기. 
				review = reviewService.getReviewByNo(reviewNo);
			} catch (SQLException e) {
				e.printStackTrace();
			} // 리뷰 정보 가져오기
			req.setAttribute("review", review); // 리뷰 인스턴스를 요청에 저장
			req.getRequestDispatcher("/review/edit.jsp").forward(req, res); // edit.jsp로 포워드이동
		} 
		//리뷰 리스트 보여주는 기능
		else if ("list".equals(action)) {
			doList(req, res);
			
			//리뷰 작성 기능
		} else if ("write".equals(action)) {
			doWrite(req, res);
		} else if ("review".equals(action)) {
			doReview(req, res);
		} else if ("update".equals(action)) {
			try {
				doUpdate(req, res);
			} catch (IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if ("delete".equals(action)) {
			try {
				doRemove(req, res);
			} catch (IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//삭제하기
	private void doRemove(HttpServletRequest req, HttpServletResponse res) throws IOException, SQLException {
		int reviewNo = Integer.parseInt(req.getParameter("reviewNo"));
		int videoNo = Integer.parseInt(req.getParameter("videoNo"));

		reviewService.deleteReview(reviewNo);
		
		String videoURL = (String) req.getSession().getAttribute("videoURL");

		req.setAttribute("videoURL", videoURL);

		res.sendRedirect(req.getContextPath() + "/review?action=list&videoNo=" + videoNo + "&videoURL=" + videoURL);
	}
	//수정하기.
	private void doUpdate(HttpServletRequest req, HttpServletResponse res) throws IOException, SQLException {
		int reviewNo = Integer.parseInt(req.getParameter("reviewNo"));
		int videoNo = Integer.parseInt(req.getParameter("videoNo"));
		String content = req.getParameter("content");
		String videoURL = (String) req.getSession().getAttribute("videoURL");
		
		Review review = new Review();
		review.setReviewNo(reviewNo);
		review.setContent(content);

		reviewService.updateReview(review);

		res.sendRedirect(req.getContextPath() + "/review?action=list&videoNo=" + videoNo + "&videoURL=" + videoURL);
	}
	//리뷰
	private void doReview(HttpServletRequest req, HttpServletResponse res) {
		String content = req.getParameter("content"); //
		String writer = req.getParameter("writer"); //
		Review review = new Review();
		review.setContent(content);
		review.setWriter(writer);

	}
	//리뷰 작성 
	private void doWrite(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		String videoURL = (String) req.getSession().getAttribute("videoURL");

		int video_no = Integer.parseInt(req.getParameter("videoNo"));
		Review review = new Review();
		review.setContent(content);
		review.setWriter(writer);
		review.setVideoNo(video_no);
		
		try {
			reviewService.writeReview(review);
		} catch (Exception e) {
			e.printStackTrace();
		}
		res.sendRedirect(req.getContextPath() + "/review?action=list&videoNo=" + review.getVideoNo() + "&videoURL=" + videoURL);
	}
	
	private void doList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Review> reviews = null;
		int videoNo = 0;
		String videoURL = "";
		try {
			Member member = new Member();
			member = (Member) req.getSession().getAttribute("member");

			videoNo = Integer.parseInt(req.getParameter("videoNo"));
			reviews = reviewService.getAllReviews(videoNo);
			videoURL = (String) req.getParameter("videoURL");

			req.getSession().setAttribute("videoURL", videoURL);
			
			req.setAttribute("reviews", reviews);
			req.setAttribute("videoNo", videoNo);
			req.setAttribute("videoURL", videoURL);
			req.getRequestDispatcher("/review/list.jsp").forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
