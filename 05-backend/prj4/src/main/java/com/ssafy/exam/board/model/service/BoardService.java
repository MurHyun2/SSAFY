package com.ssafy.exam.board.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.exam.board.model.dto.Board;

public interface BoardService {
	// 전체 비디오 조회
	public abstract List<Board> getAllBoards() throws SQLException;

	// 게시글 조회
	public abstract Board getBoardByNo(int no);

	// 게시글 작성
	public abstract void writeBoard(Board board);

	// 게시글 수정
	public abstract void modifyBoard(Board board);

	// 게시글 삭제
	public abstract void removeBoard(int no);
}
