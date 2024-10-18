package com.ssafy.myboard.board.model.dao;

import java.util.List;

import com.ssafy.myboard.board.model.Board;
import com.ssafy.myboard.board.model.BoardFile;

public interface BoardDao {
	List<Board> selectBoardAll();

	Board selectBoardOne(int no);

	void insertBoard(Board board);

	void updateBoard(Board board);

	void deleteBoard(int no);

	void insertBoardFile(BoardFile boardFile);

	BoardFile selectBoardFileByNo(int no);
}
