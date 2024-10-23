package com.ssafy.mvc.model.dao;

import java.util.List;

import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.BoardSearch;

public interface BoardDao {
	// 전체 게시글을 조회
	public abstract List<Board> selectAll(BoardSearch boardSearch);
	
	// 게시물 페이징 처리를 위한 전체 데이터 카운트
	public int selectBoardCount(BoardSearch boardSearch);

	// ID에 해당하는 게시글 하나 가져오기
	public abstract Board selectOne(int id);

	// 게시글 등록
	public void insertBoard(Board board);

	// 게시글 삭제
	public void deleteBoard(int id);

	// 게시글 수정
	public void updateBoard(Board board);

	// 조회수 증가
	public void updateViewCnt(int id);

	public List<Board> search(BoardSearch boardSearch);
	
	// 게시물 페이징 처리를 위한 검색 데이터 카운트
	public int selectSearchBoardCount(BoardSearch boardSearch);

}
