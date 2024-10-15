package com.ssafy.myboard.board.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.myboard.board.model.Board;

public interface BoardDao {
	List<Board> selectBoardAll() throws SQLException;

	Board selectBoardOne(int no) throws SQLException;

	void insertBoard(Board board) throws SQLException;

	void updateBoard(Board board) throws SQLException;

	void deleteBoard(int no) throws SQLException;
}
