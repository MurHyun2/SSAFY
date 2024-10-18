<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${fileName }</h2>
	<img src="/img/${fileName }">
	<a href="/img/${fileName }">${fileName }</a>
	<a href="/download?fileName=${fileName }">Download</a>
</body>
</html>