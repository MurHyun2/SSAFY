package com.ssafy.off.day06.board;

import java.util.Arrays;

public class BoardManager {

	private BoardManager() {
	}

	private static BoardManager instance = new BoardManager();

	public static BoardManager getInstance() {
		return instance;
	}

	final int MAX_SIZE = 10;
	Board[] boardList = new Board[MAX_SIZE];
	int size = 0;

	boolean add(Board board) {
		if (size == MAX_SIZE)
			return false;
		boardList[size++] = board;
		return true;
	}

	Board getBoard(int no) {
		for (int i = 0; i < size; i++) {
			Board b = boardList[i];
			if (b.getNo() == no) {
				return b;
			}
		}
		return null;
	}

	Board[] getBoards() {
//		Board[] temp = new Board[size];
//		for (int i = 0; i < size; i++) {
//			temp[i] = boardList[i];
//		}
//		return temp;
		return Arrays.copyOf(boardList, size);
	}

	boolean modify(int no, String modTitle) {
		for (int i = 0; i < size; i++) {
			Board b = boardList[i];
			if (b.getNo() == no) {
				b.setTitle(modTitle);
				return true;
			}
		}

		return false;
	}

	boolean delete(int no) {
		for (int i = 0; i < size; i++) {
			Board b = boardList[i];
			if (b.getNo() == no) {
				int moved = size - i - 1;
				if (moved != 0)
					System.arraycopy(boardList, i + 1, boardList, i, moved);
				else
					boardList[--size] = null;
				return true;
			}
		}
		return false;
	}

}
