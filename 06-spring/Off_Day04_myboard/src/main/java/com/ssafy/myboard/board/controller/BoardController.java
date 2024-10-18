package com.ssafy.myboard.board.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.myboard.board.model.Board;
import com.ssafy.myboard.board.model.BoardFile;
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
		Board board = boardService.getBoard(no);
		model.addAttribute("board", board);
		return "board/boardDetail";
	}

	@GetMapping("boardInsert")
	public String boardInsert() throws Exception {
		return "board/boardInsertForm";
	}

	@PostMapping("boardInsert")
	public String boardInsert(@RequestParam("attach") MultipartFile attach, Board board) throws Exception {

		String oriName = attach.getOriginalFilename();

		if (oriName.length() > 0) {
			String subDir = new SimpleDateFormat("/yyyy/MM/dd/HH").format(new Date());
			File dir = new File("c:/SSAFY/uploads" + subDir);
			dir.mkdirs();

			String systemName = UUID.randomUUID().toString() + oriName;
			attach.transferTo(new File(dir, systemName));

			// DB에 저장하기 위한 준비
			BoardFile boardFile = new BoardFile();
//			boardFile.setFileNo(0); // 데이터 입력시 자동 입력
			boardFile.setFilePath(subDir);
			boardFile.setOriName(oriName);
			boardFile.setSystemName(systemName);
//			boardFile.setNo(0); //board 테이블에 데이터가 입력된 다음 가능
			board.setBoardFile(boardFile);
		}

		boardService.addBoard(board);
		return "redirect:/board/boardList";
	}

	@GetMapping("boardUpdate")
	public String boardUpdate(@RequestParam int no, Model model) throws Exception {
		model.addAttribute("board", boardService.getBoard(no));
		return "board/boardUpdateForm";
	}

	@PostMapping("boardUpdate")
	public String boardUpdate(Board board) throws Exception {
		boardService.modifyBoard(board);
		return "redirect:/board/boardDetail?no=" + board.getNo();
	}

	@PostMapping("boardDelete")
	public String boardDelete(@RequestParam int no) throws Exception {
		boardService.removeBoard(no);
		return "redirect:/board/boardList";
	}
}
