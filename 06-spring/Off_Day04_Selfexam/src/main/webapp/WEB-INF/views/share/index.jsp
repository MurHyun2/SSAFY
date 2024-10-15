<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
</head>
<body>
	<h1>04Share Page</h1>
	<h2>test1 - 공유된 데이터 확인1 - User: ${user }</h2>
	<h2>test1 - 공유된 데이터 확인2 - u: ${u }</h2>
	<h2>test2 - 공유된 데이터 확인1 - Model : ${msg} ${hello}</h2>
	<h2>test2 - 공유된 데이터 확인1 - Map : ${mapMsg} ${mapHello}</h2>
	<h2>
		<a href="/hello">go to hello</a>
	</h2>
	<h2>
		<a href="${pageContext.request.contextPath }/share/test1?id=abcd&pass=1111">ModelAttribute 공유</a>
	</h2>
	<h2>
		<a href="${pageContext.request.contextPath }/share/test2?id=abcd&pass=1111">Model 공유</a>
	</h2>
	<h2>
		<a href="${pageContext.request.contextPath }/share/test3?id=abcd&pass=1111">Map 공유</a>
	</h2>
</body>
</html>
