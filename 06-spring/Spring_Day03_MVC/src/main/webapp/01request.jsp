<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>
		<a href="${pageContext.request.contextPath }/request/test1">test1 Call</a>
	</h2>
	<h2>
		<a href="${pageContext.request.contextPath }/request/test2">test2 Call</a>
	</h2>
	<h2>
		<a href="${pageContext.request.contextPath }/request/test3">test3 Call</a>
	</h2>
	<h2>
		<a href="${pageContext.request.contextPath }/request/test4">test4 Call</a>
	</h2>
	<h2>
		<a href="${pageContext.request.contextPath }/request/test5-1">test5-1 Call</a>
		<a href="${pageContext.request.contextPath }/request/test5-2">test5-2 Call</a>
	</h2>
	<h2>
		<a href="${pageContext.request.contextPath }/request/test6">test6 Call</a>
	</h2>
	<form action="${pageContext.request.contextPath }/request/test7" method="POST">
		<h2>
			<button>test7 Call</button>
		</h2>
	</form>
	<h2>
		<a href="${pageContext.request.contextPath }/request/test8">test8 Call</a>
	</h2>
	<form action="${pageContext.request.contextPath }/request/test9" method="POST">
		<h2>
			<button>test9 Call</button>
		</h2>
	</form>
</body>
</html>