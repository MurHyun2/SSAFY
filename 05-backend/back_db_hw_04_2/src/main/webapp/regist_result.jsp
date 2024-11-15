<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 등록 결과</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid black;
}

th:nth-child(1) {
	width: 120px;
}
</style>
</head>
<body>
<%--분리한 header.jsp 가져오기 --%>
	<%@ _______ file="_________"%>
	<h1>사용자 등록 결과</h1>
	<h2>등록된 사용자 정보</h2>
	<table>
		<thead>
			<tr>
				<th>항목</th>
				<th>내용</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>아이디</td>
				<td>____________</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>____________</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>____________</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>____________</td>
			</tr>
			<tr>
				<td>나이</td>
				<td>____________</td>
			</tr>
		</tbody>
	</table>
	<!-- 다시 사용자를 등록할 수 있는 링크를 제공한다. -->
	<a href="regist.jsp">추가등록</a>
	<%-- 사용자 목록 조회를 위한 링크 추가 --%>
	<a href="___________">사용자 목록</a>
</body>
</html>
