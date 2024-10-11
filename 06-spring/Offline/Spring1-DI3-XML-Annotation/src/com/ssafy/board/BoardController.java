package com.ssafy.board;

import org.springframework.stereotype.Controller;

@Controller
public class BoardController {
	private final BoardService boardService;

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	public void addBoard(String board) {
		boardService.addBoard(board);
	}
}
