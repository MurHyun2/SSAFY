package com.ssafy.myboard.board.model;

public class Board {
	private int no;
	private String title;
	private String content;
	private int viewCnt;
	private String regDate;

	public Board() {
		super();
	}

	public Board(int no, String title, String content, int viewCnt, String regDate) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.viewCnt = viewCnt;
		this.regDate = regDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Board [no=" + no + ", title=" + title + ", content=" + content + ", viewCnt=" + viewCnt + ", regDate="
				+ regDate + "]";
	}

}
