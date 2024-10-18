<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>SingleFileForm</h2>
	<form action="/multiFileUpload" method="post" enctype="multipart/form-data">
		<input type="file" name="files" multiple="multiple">
		<button>File Upload</button>
	</form>
</body>
</html>