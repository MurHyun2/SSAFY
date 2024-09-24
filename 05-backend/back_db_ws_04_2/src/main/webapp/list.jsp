<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 사용자 관리</title>
<style>
#user-list {
	border-collapse: collapse;
	width: 100%;
}

#user-list td, #user-list th {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h1>영화 목록</h1>
	<h2>지금까지 등록한 영화 수 : ${list.size() }</h2>
	<table id="user-list">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>감독</th>
				<th>개요</th>
				<th>상영시간</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="movie" >
				<tr>
					<td>${movie.id }</td>
					<td>${movie.title }</td>
					<td>${movie.director }</td>
					<td>${movie.genre }</td>
					<td>${movie.runningTime }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="regist.jsp">추가등록</a>
</body>
</html>
