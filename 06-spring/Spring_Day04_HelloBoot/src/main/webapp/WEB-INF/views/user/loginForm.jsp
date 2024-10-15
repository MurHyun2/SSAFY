<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
</head>
<body>
	<h2>Login Page</h2>
	<form action="/login" method="post">
		ID : <input type="text" name="id">
		PW : <input type="password" name="pw">
		<button>Login</button>
	</form>
</body>
</html>
