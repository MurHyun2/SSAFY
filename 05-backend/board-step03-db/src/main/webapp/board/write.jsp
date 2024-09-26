<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- JSTL 태그 라이브러리 변경 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <h2>대전 4반 게시판</h2>
    <form action="${pageContext.request.contextPath}/board" method="post">
        <input type="hidden" name="action" value="write" />
        <table>
            <tr>
                <td>제목</td>
                <td><input type="text" name="title" /></td>
            </tr>
            <tr>
                <td>작성자</td>
                <c:if test="${not empty cookies}">
                    <c:forEach var="cookie" items="${cookies}">
                        <c:if test="${cookie.name != 'JSESSIONID'}">
                            <td><input type="text" name="writer" value="${cookie.value}" /></td>
                        </c:if>
                    </c:forEach>
                </c:if>
                <c:if test="${empty cookies}">
                    <td><input type="text" name="writer" placeholder="작성자 입력" /></td>
                </c:if>
            </tr>
            <tr>
                <td>내용</td>
                <td><textarea name="content" rows="8" cols="80"></textarea></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button>등록</button>
                </td>
            </tr>
        </table>
    </form>
    <a href="javascript:window.history.back();">뒤로가기</a>
</body>
</html>
