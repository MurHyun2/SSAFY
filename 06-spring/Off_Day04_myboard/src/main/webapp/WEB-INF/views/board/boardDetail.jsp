<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
</head>
<body>
	<c:set var="path" value="${pageContext.request.contextPath }" />
	<h1>HELLO! DETAIL PAGE</h1>
	<a href="${path}/board/boardList">게시판 이동</a>

	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>내용</td>
			<td>조회수</td>
			<td>날짜</td>
			<td>첨부파일</td>
		</tr>
		<tr>
			<td>${board.no }</td>
			<td>${board.title }</td>
			<td>${board.content }</td>
			<td>${board.viewCnt }</td>
			<td>${board.regDate }</td>
			<td>${board.boardFile.oriName }</td>
		</tr>
	</table>
	<span><a href="${path}/board/boardInsert">입력창</a></span>
	<span><a href="${path}/board/boardUpdate?no=${board.no }">수정창</a></span>
	<form action="${path}/board/boardDelete?no=${board.no }" method="post">
		<button>삭제</button>
	</form>
</body>
</html>
