package com.ssafy.exam.board.model.repository;

import java.util.List;

import com.ssafy.exam.board.model.dto.Board;

public interface BoardRepository {
	// 전체 비디오 가져오기
	public abstract List<Board> selectAll();

	// 비디오 조회
	public abstract Board selectOne();

	// 비디오 등록하기
	public abstract void insertBoard(Board board);

	// 비디오 수정하기
	public abstract void updateBoard(Board board);

	// 비디오 삭제하기
	public abstract void deleteBoard(int id);
}
