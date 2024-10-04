package com.ssafy.exam.review.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.exam.review.model.Review;

public interface ReviewService {
//자바 용어로 
	
	List<Review> getAllReviews(int videoNo) throws Exception;
	
	Review getReviewByNo(int videoNo) throws SQLException;
	
	void writeReview(Review review) throws Exception;


	void updateReview(Review review) throws SQLException;
	
	void deleteReview(int reviewNo) throws SQLException;

	
}
