package com.ssafy.ws.day04.step4;

/**
 * 리뷰 정보를 나타내는 클래스
 */
public class Review {
	int reviewId;
	int resId;
	String writer;
	String content;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(int reviewId, int resId, String writer, String content) {
		this.reviewId = reviewId;
		this.resId = resId;
		this.writer = writer;
		this.content = content;
	}
	
	@Override
	public String toString() {
		String result = String.format("Review [reviewId=%d, resId=%d, writer=%s, content=%s]", reviewId, resId, writer, content);
		return result;
	}
}
