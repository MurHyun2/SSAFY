package com.ssafy.exam.board.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.exam.board.model.dto.Board;

public interface BoardDAO {

	Board selectBoard(int no) throws SQLException;

	List<Board> selectBoardList() throws SQLException;

	void insertBoard(Board board) throws SQLException;

	void updateBoard(int no, String title, String content) throws SQLException;

	void deleteBoard(int no) throws SQLException;

	void updateViewCnt(int no) throws SQLException;

}