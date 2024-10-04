package com.ssafy.exam.review.model;

public class Review {
	private int reviewNo; // 리뷰번
	private int videoNo; // 리뷰번
	private String title; //제목
	private String writer; //작성자
	private String content; //내용
	private String regDate; //작성시간.
	private int viewCnt; //조회수 
	
	public Review() {
		
	}
	
	public Review(int reviewNo, int videoNo, String title, String writer, String content, String regDate, int viewCnt) {
		this.reviewNo = reviewNo;
		this.videoNo = videoNo;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regDate = regDate;
		this.viewCnt = viewCnt;
	}



	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getVideoNo() {
		return videoNo;
	}

	public void setVideoNo(int videoNo) {
		this.videoNo = videoNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", videoNo=" + videoNo + ", title=" + title + ", writer=" + writer
				+ ", content=" + content + ", regDate=" + regDate + ", viewCnt=" + viewCnt + "]";
	}


	

}
