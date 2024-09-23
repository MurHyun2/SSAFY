<%@page import="com.ssafy.exam.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Member memberInfo = (Member) session.getAttribute("memberInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<nav>
			<ul>
				<%
					if(memberInfo == null) {
				%>
				<li><a href="<%=request.getContextPath()%>/member?action=signInForm">SignIn</a></li>
				<li><a href="<%=request.getContextPath()%>/member?action=signUpForm">SignUp</a></li>
				<%
					} else {
				%>
				<li><a href="">MyPage</a></li>
				<li><a href="<%=request.getContextPath()%>/member?action=signOut">SignOut</a></li>
				<%
					}
				%>
			</ul>
		</nav>
	</header>

	<h2>대전 4반 - 메인 페이지</h2>
	<div>
		<a href="<%=request.getContextPath()%>/board?action=list">게시판 이동</a>
	</div>
</body>
</html>