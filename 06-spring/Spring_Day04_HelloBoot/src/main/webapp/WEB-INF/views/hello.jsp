<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
</head>
<body>
	<!-- 로그인 X 로그인 페이지  -->
	<c:if test="${empty loginUser }">
		<a href="login">Login</a>
	</c:if>

	<!-- 로그인 O 로그아웃  -->
	<c:if test="${not empty loginUser }">
		<span>Hello, ${loginUser }!</span>
		<a href="/logout">Logout</a>
	</c:if>

	<h2>${msg }</h2>
</body>
</html>
