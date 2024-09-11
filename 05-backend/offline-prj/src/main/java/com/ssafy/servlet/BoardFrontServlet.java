package com.ssafy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.servlet.BoardServlet.Board;

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

@WebServlet("/mvc/board")
public class BoardFrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		// http://localhost:8080/offline-prj/mvc/board
		String type = req.getParameter("type");
		if (type == null)
			type = "list";

		switch (type) {
		case "list": {
			list(req, rsp);
			break;
		}
		case "write": {
			write(req, rsp);
			break;
		}
		case "writeForm": {
			writeForm(req, rsp);
			break;
		}
		}
	}

	/*
	 * 게시글 등록 http://localhost:8080/offline-prj/mvc/board body 부분에
	 * type=write&title=~~&content=~~&writer=~~
	 */
	private void writeForm(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
		String html = """
				<!DOCTYPE html>
				<html lang="en">
				<head>
				    <meta charset="UTF-8">
				    <meta name="viewport" content="width=device-width, initial-scale=1.0">
				    <title>Document</title>
				</head>
				<body>
				    <!-- 게시판 등록폼 -->
				    <!-- 필수 : 제목, 내용, 작성자 -->
				     <form action="http://localhost/offline-prj/mvc/board?type=write" method="post">
				     	<input type="text" name="type" value="write" hidden/>
				        <label for="">제목<input type="text" name="title"></label><br>
				        <label for="">내용<input type="text" name="content"></label><br>
				        <label for="">작성자<input type="text" name="author"></label><br>
				        <button>작성하기</button>
				     </form>
				</body>
				</html>
				""";

		rsp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = rsp.getWriter();
		out.print(html);
		out.close();
	}

	private void write(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
		String t = req.getParameter("title");
		String c = req.getParameter("content");
		String a = req.getParameter("author");

		list.add(new Board(list.size() + 1, t, c, a));

		String html = """
					<html>
						<head>
							<title>등록</title>
						</head>
						<body>
							<script>
								alert("등록되었습니다")
								location.href="board";
							</script>
						</body>
					</html>
				""";

		rsp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = rsp.getWriter();
		out.print(html);
		out.close();
	}

	/*
	 * 게시글 조회 http://localhost:8080/offline-prj/mvc/board?type=list
	 */
	private void list(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
		rsp.setContentType("text/html;charset=UTF-8");

		PrintWriter out = rsp.getWriter();

		String trHtml = "";

		for (Board brd : list) {
			trHtml += ("""
					<tr>
					<td>%d</td>
					<td>%s</td>
					<td>%s</td>
					</tr>
					""".formatted(brd.no, brd.title, brd.author));
		}

		if (list.isEmpty())
			trHtml = "<tr><td colspan ='3'>게시글이 존재하지 않습니다.</td></tr>";

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
				        	%s
						</table>
				    </div>
				    <div>
					    <a href="http://localhost/offline-prj/mvc/board?type=writeForm">글쓰기</a>
					</div>
				</body>
				</html>
				""".formatted(trHtml));

		out.close();

	}
}
