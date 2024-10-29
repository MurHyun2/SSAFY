package com.ssafy.board.model.service;

import com.ssafy.board.model.dao.BoardDAO;

public class BoardServiceImpl implements BoardService {
	private final BoardDAO boardDao;

	public BoardServiceImpl(BoardDAO boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public void addBoard(String msg) {
		System.out.println("SERVICEIMPL CALLED");
		boardDao.insert(msg);
	}
}
