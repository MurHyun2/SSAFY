package com.ssafy.myboard.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.myboard.board.model.Board;
import com.ssafy.myboard.board.model.dao.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardDao boardDao;

	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public List<Board> getBoardList() throws Exception {
		return boardDao.selectBoardAll();
	}

	@Override
	public Board getBoard(int no) throws Exception {
		return boardDao.selectBoardOne(no);
	}

	@Override
	public void addBoard(Board board) throws Exception {
		boardDao.insertBoard(board);
	}

	@Override
	public void modifyBoard(Board board) throws Exception {
		boardDao.updateBoard(board);
	}

	@Override
	public void removeBoard(int no) throws Exception {
		boardDao.deleteBoard(no);
	}

}
