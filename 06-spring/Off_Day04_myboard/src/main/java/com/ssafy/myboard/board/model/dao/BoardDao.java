package com.ssafy.myboard.board.model.dao;

import java.util.List;

import com.ssafy.myboard.board.model.dto.Board;
import com.ssafy.myboard.board.model.dto.BoardFile;

public interface BoardDao {
	List<Board> selectBoardAll();

	Board selectBoardOne(int no);

	void insertBoard(Board board);

	void updateBoard(Board board);

	void deleteBoard(int no);

	void insertBoardFile(BoardFile boardFile);

	BoardFile selectBoardFileByNo(int no);
	
	void updateViewCntByNo(int no);
}
