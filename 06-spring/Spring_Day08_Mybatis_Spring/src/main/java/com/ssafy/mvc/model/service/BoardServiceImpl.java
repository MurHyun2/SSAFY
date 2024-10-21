package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.BoardDao;
import com.ssafy.mvc.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardDao boardDao;

	public BoardServiceImpl(BoardDao boardDao) {
		super();
		this.boardDao = boardDao;
	}

	@Override
	public List<Board> getBoardList() {
		System.out.println("모든 게시글 가지고 왔습니다");
		return boardDao.selectAll();
	}

	@Override
	public Board readBoard(int id) {
		return boardDao.selectOne(id);
	}

	@Override
	public void writeBoard(Board board) {
		System.out.println("게시글 작성했습니다.");
		boardDao.insertBoard(board);
	}

	@Override
	public void removeBoard(int id) {
		boardDao.deleteBoard(id);
		System.out.println("게시글 삭제 완료");
	}

	@Override
	public void modifyBoard(Board board) {
		boardDao.updateBoard(board);
		System.out.println("게시글 수정 완료");
	}

	@Override
	public void updateViewCnt(int id) {
		boardDao.updateViewCnt(id);
	}

}
