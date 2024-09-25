<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<c:set value="${pageContext.request.contextPath}" var="cp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시판 상세</h2>
	<div class="board-detail">
		<div>
			<label>번호</label> ${board.no }
		</div>
		<div>
			<label>제목</label> ${board.title }
		</div>
		<div>
			<label>내용</label> ${board.content }
		</div>
		<div>
			<label>조회수</label> ${board.views }
		</div>
		<a href="${cp }/board?action=list">뒤로가기</a>
		<a href="${cp }/board?action=updateForm&no=${board.no}">글 수정</a>
		<a href="${cp }/board?action=delete&no=${board.no}">글 삭제</a>
	</div>
</body>
</html>