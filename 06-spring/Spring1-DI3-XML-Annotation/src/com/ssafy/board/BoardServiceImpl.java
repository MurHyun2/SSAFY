package com.ssafy.board;

import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	private final BoardDAO boardDao;

	public BoardServiceImpl(BoardDAO boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public void addBoard(String board) {
		boardDao.insertBoard(board);
	}
}
