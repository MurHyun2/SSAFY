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
		</tr>
		<tr>
			<td>${board.no }</td>
			<td>${board.title }</td>
			<td>${board.content }</td>
			<td>${board.viewCnt }</td>
			<td>${board.regDate }</td>
		</tr>
	</table>
	<span><a href="${path}/board/boardInsertForm">입력창</a></span>
	<span><a href="${path}/board/boardUpdateForm?no=${board.no }">수정창</a></span>
	<span><a href="${path}/board/boardDelete?no=${board.no }">삭제</a></span>
</body>
</html>
