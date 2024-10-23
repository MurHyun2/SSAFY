package com.ssafy.mvc.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.mvc.model.dao.BoardDao;
import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.BoardSearch;
import com.ssafy.mvc.util.PageResult;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardDao boardDao;

	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public Map<String, Object> getBoardList(BoardSearch boardSearch) {
		Map<String, Object> result = new HashMap<>();
		result.put("list", boardDao.selectAll(boardSearch));
		result.put("pr", new PageResult(boardSearch.getPage(), boardDao.selectBoardCount(boardSearch),
				boardSearch.getListSize()));
		System.out.println(new PageResult(boardSearch.getPage(), boardDao.selectBoardCount(boardSearch),
				boardSearch.getListSize()));

		System.out.println("모든 게시글 가지고 왔습니다");
		return result;
	}

	@Override
	public Board readBoard(int id) {
		return boardDao.selectOne(id);
	}

	@Transactional
	@Override
	public void writeBoard(Board board) {
		System.out.println("게시글 작성했습니다.");
		boardDao.insertBoard(board);
	}

	@Transactional
	@Override
	public void removeBoard(int id) {
		boardDao.deleteBoard(id);
		System.out.println("게시글 삭제 완료");
	}

	@Transactional
	@Override
	public void modifyBoard(Board board) {
		boardDao.updateBoard(board);
		System.out.println("게시글 수정 완료");
	}

	@Transactional
	@Override
	public void updateViewCnt(int id) {
		boardDao.updateViewCnt(id);
	}

//	@Override
//	public List<Board> search(SearchCondition condition) {
//		System.out.println();
//		
//		return boardDao.search(condition);
//	}
	
	@Override
	public Map<String, Object> search(BoardSearch boardSearch) {
		Map<String, Object> result = new HashMap<>();
		result.put("list", boardDao.search(boardSearch));
		result.put("pr", new PageResult(boardSearch.getPage(), boardDao.selectSearchBoardCount(boardSearch),
				boardSearch.getListSize()));

		System.out.println("모든 게시글 가지고 왔습니다");
		return result;
	}

}
