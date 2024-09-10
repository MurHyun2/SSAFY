package com.ssafy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
사용자가 전송한 제목, 내용, 작성자 파라미터를 꺼낸다.
꺼낸 데이터를 사용자에게 확인시켜준다.

-----------------------------------
번호        제목               작성자
-----------------------------------
1        작성한 제목            작성한 이름
-----------------------------------
*/

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	static class Board {
		int no;
		String title, content, author;

		public Board(int no, String title, String content, String author) {
			super();
			this.no = no;
			this.title = title;
			this.content = content;
			this.author = author;
		}
	}

	static List<Board> list = new ArrayList<>();

	public void service(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
		rsp.setContentType("text/html;charset=UTF-8");

		PrintWriter out = rsp.getWriter();

		String t = req.getParameter("title");
		String c = req.getParameter("content");
		String a = req.getParameter("author");

		list.add(new Board(list.size() + 1, t, c, a));

		out.print("""
				<!DOCTYPE html>
				<html lang="en">
				<head>
				    <meta charset="UTF-8">
				    <meta name="viewport" content="width=device-width, initial-scale=1.0">
				    <title>Document</title>
				</head>
				<body>
				    <div>
				        <table id="tbl" border="1">
				            <thead>
				            <td>번호</td>
				            <td>제목</td>
				            <td>작성자</td>
				        </thead>

				""");

		for (Board brd : list) {
			out.print("""
					<tr>
					<td>%d</td>
					<td>%s</td>
					<td>%s</td>
					</tr>
					""".formatted(brd.no, brd.title, brd.author));
		}

		out.print(
				"""

						</table>
						    </div>
						    <div>
						    <button type="button" onclick="location.href='http://127.0.0.1:5500/src/main/webapp/board.html'">
						    	돌아가기
						    </button>
						</div>
						</body>
						</html>
						""");

	}

}
