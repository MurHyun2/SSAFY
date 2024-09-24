package com.ssafy.exam;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.tags.shaded.org.apache.regexp.recompile;

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
		for (Board b : bList) {
			if (b.getNo() == no)
				return b;
		}

		return null;
	};

	public List<Board> selectBoardList() {
		return bList;
	};

	public void insertBoard(Board board) {
		board.setNo(++bNo);
		bList.add(board);
	};

	public void updateBoard(int no, String title, String content) {
		for (Board b : bList) {
			if (b.getNo() == no) {
				b.setTitle(title);
				b.setContent(content);
				return;
			}
		}
	};

	public void deleteBoard(int no) {
		for (Board b : bList) {
			if (b.getNo() == no) {
				bList.remove(b);
				return;
			}
		}
	}

	public void updateViewCnt(int no) {
		for (Board b : bList) {
			if (b.getNo() == no) {
				b.setViews(b.getViews() + 1);
				return;
			}
		}
	};

}
