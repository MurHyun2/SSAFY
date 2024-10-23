package com.ssafy.mvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.BoardSearch;
import com.ssafy.mvc.model.service.BoardService;

@Controller
public class BoardController {

	private final BoardService boardService;

//	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@GetMapping("list")
	public String list(@ModelAttribute BoardSearch boardSearch, Model model) {
		// Service를 통해서 게시글들을 가져와야한다.
		Map<String, Object> result = boardService.getBoardList(boardSearch);
		model.addAttribute("boards", result.get("list"));
		model.addAttribute("pr", result.get("pr"));

		return "board/list";
	}

	@GetMapping("writeform")
	public String writeform() {
		return "board/writeform";
	}

	@PostMapping("write")
	public String postMethodName(@ModelAttribute Board board) {
		boardService.writeBoard(board);
		return "redirect:list";
	}

	@GetMapping("detail")
	public String detail(@RequestParam int id, Model model) {
		boardService.updateViewCnt(id);
		Board board = boardService.readBoard(id);
		model.addAttribute("board", board);
		return "board/detail";
	}

	@GetMapping("updateform")
	public String updateform(@RequestParam int id, Model model) {
		Board board = boardService.readBoard(id);
		model.addAttribute("board", board);
		return "board/updateform";
	}

	@PostMapping("update")
	public String update(@ModelAttribute Board board) {
		boardService.modifyBoard(board);
		return "redirect:detail?id=" + board.getId();
	}

	@GetMapping("delete")
	public String delete(@RequestParam int id) {
		boardService.removeBoard(id);
		return "redirect:list";
	}
	
	@GetMapping("search")
	public String search(@ModelAttribute BoardSearch boardSearch, Model model) {
		Map<String, Object> result = boardService.search(boardSearch);
		model.addAttribute("boards", result.get("list"));
		model.addAttribute("pr", result.get("pr"));
		model.addAttribute("search", boardSearch);
		return "board/list";
	}
}
