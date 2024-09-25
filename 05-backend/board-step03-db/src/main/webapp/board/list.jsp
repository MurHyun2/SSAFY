<%@page import="com.ssafy.exam.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%
List<Board> list = (List<Board>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>대전 4반 게시판</h2>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${list }" var="b">
			<tr>
				<td>${b.no }</td>
				<td><a href="${pageContext.request.contextPath}/board?action=detail&no=${b.no}">${b.title }</td>
				<td>${b.writer }</td>
				<td>${b.views }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/board?action=writeForm">글쓰기</a>
	<a href="javascript:window.history.back();">뒤로가기</a>
</body>
</html>