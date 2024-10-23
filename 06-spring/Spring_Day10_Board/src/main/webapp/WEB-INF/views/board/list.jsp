<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>게시글 목록</title>
<%@ include file="../common/bootstrap.jsp" %>
</head>
<body>
	<div class="container">
		<h2>게시글 목록</h2>
		<%@ include file="../common/header.jsp" %>
		<hr>
		<div class="form-group">
            <label for="listSize">한 페이지당 게시물 수:</label>
            <select id="listSize" class="custom-select" onchange="movePage(this.value)">
                <option value="5" <c:if test="${pr.listSize == 5}">selected</c:if>>5개</option>
                <option value="10" <c:if test="${pr.listSize == 10}">selected</c:if>>10개</option>
                <option value="20" <c:if test="${pr.listSize == 20}">selected</c:if>>20개</option>
                <option value="50" <c:if test="${pr.listSize == 50}">selected</c:if>>50개</option>
            </select>
        </div>
		<%@ include file="../common/searchForm.jsp" %>
		<table class="table text-center">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>쓰니</th>
				<th>조회수</th>
				<th>내용</th>
				<th>날짜</th>
			</tr>
			<c:forEach items="${boards}" var="board">
				<tr>
					<td>${board.id }</td>
					<td><a href="detail?id=${board.id }">${board.title }</a></td>
					<td>${board.writer }</td>
					<td>${board.viewCnt }</td>
					<td>${board.content }</td>
					<td>${board.regDate }</td>
				</tr>
			</c:forEach>	
		</table>
		<nav class="d-flex justify-content-center">
            <ul class="pagination">
                <c:if test="${pr.prev}">
                    <li class="page-item">
                        <a class="page-link" href="search?page=1&listSize=${pr.listSize}&key=${search.key}&word=${search.word}&orderBy=${search.orderBy}&orderByDir=${search.orderByDir}">첫 페이지</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="search?page=${pr.beginPage - 1}&listSize=${pr.listSize}&key=${search.key}&word=${search.word}&orderBy=${search.orderBy}&orderByDir=${search.orderByDir}">이전</a>
                    </li>
                </c:if>
                <c:forEach var="i" begin="${pr.beginPage}" end="${pr.endPage}">
                    <li class="page-item <c:if test='${pr.page == i}'>active</c:if>">
                        <a class="page-link" href="search?page=${i}&listSize=${pr.listSize}&key=${search.key}&word=${search.word}&orderBy=${search.orderBy}&orderByDir=${search.orderByDir}">${i}</a>
                    </li>
                </c:forEach>

                <c:if test="${pr.next}">
                    <li class="page-item">
                        <a class="page-link" href="search?page=${pr.endPage + 1}&listSize=${pr.listSize}&key=${search.key}&word=${search.word}&orderBy=${search.orderBy}&orderByDir=${search.orderByDir}">다음</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="search?page=${pr.lastPage}&listSize=${pr.listSize}&key=${search.key}&word=${search.word}&orderBy=${search.orderBy}&orderByDir=${search.orderByDir}">마지막 페이지</a>
                    </li>
                </c:if>
            </ul>
        </nav>
		<div class="d-flex justify-content-end">
			<a class="btn btn-outline-primary" href="/writeform">글등록</a>
		</div>
	</div>
	<script>
    	function movePage(listSize) {
    		location.href="search?key=${search.key}&word=${search.word}&orderBy=${search.orderBy}&orderByDir=${search.orderByDir}&listSize=" + listSize;
    	}
    </script>	
</body>
</html>
