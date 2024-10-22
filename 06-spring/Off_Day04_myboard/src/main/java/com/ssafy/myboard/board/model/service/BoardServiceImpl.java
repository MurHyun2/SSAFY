package com.ssafy.myboard.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.myboard.board.model.dao.BoardDao;
import com.ssafy.myboard.board.model.dto.Board;
import com.ssafy.myboard.board.model.dto.BoardFile;
import com.ssafy.myboard.board.model.dto.BoardSearch;
import com.ssafy.myboard.util.PageResult;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardDao boardDao;

	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public Map<String, Object> getBoardList(BoardSearch boardSearch) {
		// 페이징 처리를 위한 전체 게시물 카운트

		Map<String, Object> result = new HashMap<>();
		result.put("list", boardDao.selectBoardAll(boardSearch));
		result.put("pr", new PageResult(boardSearch.getPage(), boardDao.selectBoardCount(boardSearch),
				boardSearch.getListSize()));

		return result;
	}

	@Override
	public Board getBoard(int no) {
		Board board = boardDao.selectBoardOne(no);

		BoardFile boardFile = boardDao.selectBoardFileByNo(no);
		board.setBoardFile(boardFile);

		return board;
	}

	@Override
	public void addBoard(Board board) {
		boardDao.insertBoard(board);
		BoardFile boardFile = board.getBoardFile();
		if (boardFile != null) {
			boardFile.setNo(board.getNo());
			boardDao.insertBoardFile(boardFile);
		}
	}

	@Override
	public void modifyBoard(Board board) {
		boardDao.updateBoard(board);
	}

	@Override
	public void removeBoard(int no) {
		boardDao.deleteBoard(no);
	}

	@Override
	public void modifyViewCntByNo(int no) {
		boardDao.updateViewCntByNo(no);
	}

}
