<%@page import="com.ssafy.exam.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:set value="${pageContext.request.contextPath}" var="cp"/>
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
				<c:choose>
					<c:when test="${empty sessionScope.memberInfo }">
						<li><a href="${cp }/member?action=signInForm">SignIn</a></li>
						<li><a href="${cp }/member?action=signUpForm">SignUp</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="">MyPage</a></li>
						<li><a href="${cp }/member?action=signOut">SignOut</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</header>
	<h2>대전 4반 - 메인 페이지</h2>
	<div>
		<a href="${cp }/board?action=list">게시판 이동</a>
	</div>
</body>
</html>