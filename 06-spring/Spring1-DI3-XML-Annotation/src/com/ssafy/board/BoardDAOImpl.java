package com.ssafy.board;

import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {
	public void insertBoard(String board) {
		System.out.println("게시글 저장 : " + board);
	}
}
