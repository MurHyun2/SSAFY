package com.ssafy.myboard.board.model.dto;

public class Idol {
	private int no;
	private String name;
	private String gender;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Idol [no=" + no + ", name=" + name + ", gender=" + gender + "]";
	}

}
