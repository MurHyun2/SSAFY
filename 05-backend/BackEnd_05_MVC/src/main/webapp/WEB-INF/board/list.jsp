<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<h2>게시글 목록</h2>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>쓰니</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
		<c:forEach items="${list }" var="result">
			<tr>
				<td>${result.id }</td>
				<td><a href="board?action=detail&id=${result.id }">${result.title }</a></td>
				<td>${result.writer }</td>
				<td>${result.viewCnt }</td>
				<td>${result.regDate }</td>
			</tr>
		</c:forEach>
		
		

	</table>
</body>
</html>