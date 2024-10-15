<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
</head>
<body>
	<h1>02Param Test page</h1>
	<h2><a href="/hello">go to hello</a></h2>
	<h2><a href="${pageContext.request.contextPath }/param/test1?id=hong&pass=1111">HttpServletRequest</a></h2>
	<h2><a href="${pageContext.request.contextPath }/param/test2?id=hong&pass=1111">@RequestParam</a></h2>
	<h2><a href="${pageContext.request.contextPath }/param/test3?id=hong&pass=1111">Map</a></h2>
	<h2><a href="${pageContext.request.contextPath }/param/test4?id=hong&pass=1111">DTO객체</a></h2>
</body>
</html>
