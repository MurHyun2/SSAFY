package com.ssafy.exam.board.model.dto;

public class Board {
	private int no;
	private String title;
	private String writer;
	private String content;
	private int views;

	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Board(int no, String title, String writer, String content, int views) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.views = views;
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

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	@Override
	public String toString() {
		return "Board [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", views="
				+ views + "]";
	}

}
