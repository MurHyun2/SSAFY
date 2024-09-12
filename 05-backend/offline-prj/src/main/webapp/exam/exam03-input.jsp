<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

.container {
	width: 500px;
	margin: 100px auto;
}

table {
	width: 500px;
}

table, td {
	border: 1px solid #3455;
}

td, th {
	padding: 4px;
}
</style>
<body>
	<form action="exam03.jsp">
		<input type="number" name="dan" min="2" max="9" value="2"/>
		<button>구구단</button>
	</form>
</body>
</html>