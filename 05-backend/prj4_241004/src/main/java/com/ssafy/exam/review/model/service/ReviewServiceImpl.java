package com.ssafy.exam.review.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.exam.review.model.Review;
import com.ssafy.exam.review.model.dao.ReviewDAO;
import com.ssafy.exam.review.model.dao.ReviewDAOImpl;

public class ReviewServiceImpl implements ReviewService {
	//싱글턴 객체 생성
	
	private ReviewDAO reviewDao;
	private static ReviewService instance = new ReviewServiceImpl();
	
	private ReviewServiceImpl() {
		reviewDao = ReviewDAOImpl.getInstance();
	}
	
	public static ReviewService getInstance() {
		return instance;
	}
	//리뷰 작성하기.
	@Override
	public void writeReview(Review review) throws Exception {
		reviewDao.insertReview(review);
	}
	
	//특정 비디오의 모든 리뷰 가져오기 
	public List<Review> getAllReviews(int videoNo) throws Exception {
		return reviewDao.selectAllReviews(videoNo);
	}
	
	//특정 비디오의 특정 리뷰 가져오기. 
	@Override
	public Review getReviewByNo(int reviewNo) throws SQLException {
		return reviewDao.selectReviewByNo(reviewNo);
	}
	
	//리뷰업데이트 
	@Override
	public void updateReview(Review review) throws SQLException {
		reviewDao.updateReview( review);
	}
	//리뷰삭제
	@Override
	public void deleteReview(int reviewNo) throws SQLException {
		reviewDao.deleteReview(reviewNo);
		
	}

}
