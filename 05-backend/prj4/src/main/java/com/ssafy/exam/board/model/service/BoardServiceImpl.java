package com.ssafy.exam.board.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.exam.board.model.dto.Board;
import com.ssafy.exam.board.model.repository.BoardRepository;
import com.ssafy.exam.board.model.repository.BoardRepositoryImpl;

public class BoardServiceImpl implements BoardService {
	private BoardRepository repo = BoardRepositoryImpl.getInstance();

	private static BoardService service = new BoardServiceImpl();

	private BoardServiceImpl() {
	}

	public static BoardService getInstance() {
		return service;
	}

	@Override
	public List<Board> getAllBoards() throws SQLException {
		return repo.selectAllBoards();
	}

	@Override
	public Board getBoardByNo(int no) {
		return repo.selectBoardByNo(no);
	}

	@Override
	public void writeBoard(Board board) {
		repo.insertBoard(board);
	}

	@Override
	public void modifyBoard(Board board) {
		repo.updateBoard(board);
	}

	@Override
	public void removeBoard(int no) {
		repo.deleteBoard(no);
	}
}
