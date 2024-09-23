<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>SignIn</h2>
	<form action="<%=request.getContextPath()%>/member" method="post">
		<input type="hidden" name="action" value="signIn" />
		<div>
			<label>ID</label>
			<input type="text" name="id" />
		</div>
		<div>
			<label>Password</label>
			<input type="password" name="pw" />
		</div>
		<div>
			<button>SignIn</button>
		</div>
	</form>
</body>
</html>