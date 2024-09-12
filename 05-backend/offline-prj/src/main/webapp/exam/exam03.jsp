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
	<div class="container">
		<table>
			<tr>
				<th>3단</th>
			</tr>
			<%
			for (int i = 1; i <= 9; i++) {
			%>
			<tr>
				<td><%=request.getParameter("dan") %> * <%=i%> = <%= Integer.parseInt(request.getParameter("dan")) * i %></td>
			</tr>
			<%
			}
			%>
		</table>
		<a href="exam03-input.jsp">다시입력</a>
	</div>

</body>
</html>