<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<h2>게시글 상세</h2>
		<div>
			글 제목 : ${board.title }
		</div>
		<div>
			글 쓰니 : ${board.writer }
		</div>
		<div>
			글 내용 : ${board.content }
		</div>
		<a href="board?action=delete&id=${board.id }">삭제</a>		
		<a href="board?action=updateForm&id=${board.id }">수정</a>		
		<a href="board?action=list">뒤로가기</a>		
</body>
</html>