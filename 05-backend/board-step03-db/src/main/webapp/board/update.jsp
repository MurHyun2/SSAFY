<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h2>대전 4반 게시판</h2>
	<form action="${pageContext.request.contextPath}/board" method="post">
		<input type="hidden" name="action" value="update" />
		<input type="hidden" name="no" value="${board.no }" />
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="${board.title }"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" rows="8" cols="80" >${board.content }</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<button>수정</button>
				</td>
			</tr>
		</table>
	</form>
	<a href="javascript:window.history.back();">뒤로가기</a>
</body>

</html>