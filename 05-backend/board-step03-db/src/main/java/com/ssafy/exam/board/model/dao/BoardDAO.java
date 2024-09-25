package com.ssafy.exam.board.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.exam.board.model.dto.Board;

public interface BoardDAO {

	Board selectBoard(int no);

	List<Board> selectBoardList() throws SQLException;

	void insertBoard(Board board);

	void updateBoard(int no, String title, String content);

	void deleteBoard(int no);

	void updateViewCnt(int no);

}