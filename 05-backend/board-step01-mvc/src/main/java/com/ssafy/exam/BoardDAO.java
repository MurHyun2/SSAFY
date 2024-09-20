package com.ssafy.exam;

import java.util.ArrayList;
import java.util.List;

// CRUD

public class BoardDAO {

	private static BoardDAO instance = new BoardDAO();

	private BoardDAO() {
	};

	public static BoardDAO getInstance() {
		return instance;
	}

	List<Board> bList = new ArrayList<Board>();
	int bNo = bList.isEmpty() ? 0 : bList.getFirst().getNo();

	public Board selectBoard(int no) {
		return bList.get(no);
	};

	public List<Board> selectBoardList() {
		return bList;
	};

	public void insertBoard(Board board) {
		board.setNo(++bNo);
		bList.add(board);
	};

	public void updateBoard(int no, String title, String content) {
		bList.get(no).setTitle(title);
		bList.get(no).setTitle(content);
	};

	public void deleteBoard(int no) {
		bList.remove(no);
	};

}
