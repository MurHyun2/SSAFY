package com.ssafy.myboard.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.myboard.board.model.Board;
import com.ssafy.myboard.board.model.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {
	private final BoardService boardService;

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@GetMapping("boardList")
	public String boardList(Model model) throws Exception {
		model.addAttribute("list", boardService.getBoardList());
		return "board/boardList";
	}

	@GetMapping("boardDetail")
	public String boardDetail(@RequestParam int no, Model model) throws Exception {
		model.addAttribute("board", boardService.getBoard(no));
		return "board/boardDetail";
	}

	@GetMapping("boardInsertForm")
	public String boardInsert() throws Exception {
		return "board/boardInsertForm";
	}

	@GetMapping("boardInsert")
	public String boardInsert(Board board) throws Exception {
		boardService.addBoard(board);
		return "redirect:/board/boardList";
	}

	@GetMapping("boardUpdateForm")
	public String boardUpdate(@RequestParam int no, Model model) throws Exception {
		model.addAttribute("board", boardService.getBoard(no));
		return "board/boardUpdateForm";
	}

	@GetMapping("boardUpdate")
	public String boardUpdate(Board board) throws Exception {
		boardService.modifyBoard(board);
		return "redirect:/board/boardDetail?no=" + board.getNo();
	}

	@GetMapping("boardDelete")
	public String boardDelete(@RequestParam int no) throws Exception {
		boardService.removeBoard(no);
		return "redirect:/board/boardList";
	}
}
