package com.ssafy.myboard.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.myboard.board.model.dao.BoardDao;
import com.ssafy.myboard.board.model.dto.Board;
import com.ssafy.myboard.board.model.dto.BoardFile;

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
		Board board = boardDao.selectBoardOne(no);

		BoardFile boardFile = boardDao.selectBoardFileByNo(no);
		board.setBoardFile(boardFile);

		return board;
	}

	@Override
	public void addBoard(Board board) throws Exception {
		boardDao.insertBoard(board);
		BoardFile boardFile = board.getBoardFile();
		if (boardFile != null) {
			boardFile.setNo(board.getNo());
			boardDao.insertBoardFile(boardFile);
		}
	}

	@Override
	public void modifyBoard(Board board) throws Exception {
		boardDao.updateBoard(board);
	}

	@Override
	public void removeBoard(int no) throws Exception {
		boardDao.deleteBoard(no);
	}

	@Override
	public void modifyViewCntByNo(int no) {
		boardDao.updateViewCntByNo(no);
	}

}
