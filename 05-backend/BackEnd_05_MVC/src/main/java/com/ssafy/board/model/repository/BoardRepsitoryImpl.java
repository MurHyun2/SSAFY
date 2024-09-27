package com.ssafy.board.model.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.board.model.dto.Board;

public class BoardRepsitoryImpl implements BoardRepository {
//	private List<Board> list = new ArrayList<>();
	private Map<Integer, Board> boards = new HashMap<>();

	private static BoardRepository repo = new BoardRepsitoryImpl();

	private BoardRepsitoryImpl() {
		boards.put(1, new Board("SSAFY 완벽가이드", "양띵균", "1학기를 잘.."));
	}

	public static BoardRepository getInstance() {
		return repo;
	}

	@Override
	public List<Board> selectAll() {
		List<Board> tmp = new ArrayList<>();
		for (int key : boards.keySet()) {
			tmp.add(boards.get(key));
		}

		return tmp;
	}

	@Override
	public Board selectOne(int id) {
		updateViewCnt(id);
		return boards.get(id);
	}

	@Override
	public void insertBoard(Board board) {
		boards.put(board.getId(), board);
	}

	@Override
	public void updateBoard(Board board) {
		boards.put(board.getId(), board);
	}

	@Override
	public void deleteBoard(int id) {
		boards.remove(id);
	}

	@Override
	public void updateViewCnt(int id) {
		Board b = boards.get(id);
		b.setViewCnt(b.getViewCnt() + 1);
		boards.put(id, b);
	}

}
