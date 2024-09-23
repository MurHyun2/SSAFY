<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String id = request.getParameter("id");
String pw = request.getParameter("password");

if (id.equals("ssafy") && pw.equals("123")) {
	session.setAttribute("id", id);

	//Servlet 이었다면 session을 가져오는 방법은?
	//쿠키목록을 전부 가져와서 JSESSIONID 이름을 가진 쿠키가 있는지 확인하고,
	//해당 쿠키를 이용하여 세션ID를 확보해서 가지고 온다.
	HttpSession mySession = request.getSession();
	
	//1. 포워딩
	// request.getRequestDispatcher("08_Main.jsp").forward(request, response);
	
	//2. 리다이렉트
	response.sendRedirect("08_Main.jsp");

} else {
	response.sendRedirect("07_LoginForm.jsp");
}
%>