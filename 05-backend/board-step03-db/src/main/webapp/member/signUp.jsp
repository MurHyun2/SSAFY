<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>SignUp</h2>
	<form action="${pageContext.request.contextPath }/member" method="post">
		<input type="hidden" name="action" value="signUp" />
		<div>
			<label>ID</label>
			<input type="text" name="id" />
		</div>
		<div>
			<label>Name</label>
			<input type="text" name="name" />
		</div>
		<div>
			<label>Password</label>
			<input type="password" name="pw" />
		</div>
		<div>
			<button>SignUp</button>
		</div>
	</form>
</body>
</html>