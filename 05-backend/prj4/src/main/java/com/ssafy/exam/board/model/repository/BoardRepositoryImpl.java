package com.ssafy.exam.board.model.repository;

import java.util.List;

import com.ssafy.exam.board.model.dto.Board;

public class BoardRepositoryImpl implements BoardRepository {

	private static BoardRepository repo = new BoardRepositoryImpl();

	private BoardRepositoryImpl() {
	}
	
	public static BoardRepository getInstance() {
		return repo;
	}

	@Override
	public List<Board> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board selectOne() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void insertBoard(Board board) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBoard(int id) {
		// TODO Auto-generated method stub

	}
}
