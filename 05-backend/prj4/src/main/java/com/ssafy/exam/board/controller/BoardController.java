package com.ssafy.exam.board.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ssafy.exam.board.model.dto.Board;
import com.ssafy.exam.board.model.repository.BoardRepository;
import com.ssafy.exam.board.model.repository.BoardRepositoryImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardRepository boardRepo;

	public BoardController() {
		boardRepo = BoardRepositoryImpl.getInstance();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");

		switch (action) {
		case "main":
			try {
				doMain(req, resp);
			} catch (IOException | ServletException | SQLException e) {
				e.printStackTrace();
			}
			break;
		}
	}

	private void doMain(HttpServletRequest req, HttpServletResponse resp)
	        throws IOException, ServletException, SQLException {
	    
	    // 1. 데이터베이스에서 모든 게시글을 가져와 boardList에 저장
	    List<Board> boardList = boardRepo.selectAllBoards();
	    
	    // 2. 무작위로 선택할 게시글 수를 결정하고, 무작위 인덱스를 저장할 Set 초기화
	    int maxNum = boardList.size();
	    int selectCount = Math.min(8, maxNum);
	    Set<Integer> randomIdxs = new HashSet<>();

	    // 3. 중복 없이 무작위 인덱스를 selectCount만큼 추가
	    while (randomIdxs.size() < selectCount) {
	        int randomIdx = (int) (Math.random() * maxNum);
	        randomIdxs.add(randomIdx); // 중복된 인덱스는 자동으로 제거됨
	    }

	    // 4. 선택된 인덱스를 통해 게시글 리스트에 추가하고, 순서를 무작위로 섞음
	    List<Board> list = new ArrayList<>();
	    for (int idx : randomIdxs) {
	        list.add(boardList.get(idx));
	    }
	    Collections.shuffle(list);

	    // 5. 무작위로 선택된 게시글 리스트를 요청 속성에 저장하고, JSP로 포워딩
	    req.setAttribute("listRandom", list);
	    req.setAttribute("listAll", boardList);
	    
	    RequestDispatcher rd = req.getRequestDispatcher("main.jsp");
	    rd.forward(req, resp);
	}

}
