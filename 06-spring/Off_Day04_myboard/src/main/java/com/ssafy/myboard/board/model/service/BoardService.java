package com.ssafy.myboard.board.model.service;

import java.util.List;

import com.ssafy.myboard.board.model.dto.Board;

public interface BoardService {
	List<Board> getBoardList() throws Exception;

	Board getBoard(int no) throws Exception;

	void addBoard(Board board) throws Exception;

	void modifyBoard(Board board) throws Exception;

	void removeBoard(int no) throws Exception;
	
	void modifyViewCntByNo(int no);
}
