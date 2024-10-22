<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Board List</title>
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    
    <style>
        body {
            background-color: #f8f9fa;
        }
        h1 {
            margin-top: 30px;
            text-align: center;
            color: #343a40;
        }
        table {
            margin-top: 20px;
        }
        th, td {
            text-align: center;
            vertical-align: middle;
        }
        .pagination a {
            margin: 0 5px;
        }
        .custom-btn {
            display: flex;
            justify-content: flex-end;
            margin-top: 15px;
        }
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>HELLO! LIST PAGE</h1>
        <div class="text-right mb-4">
            <a href="${path}/board/boardList" class="btn btn-primary">게시판 이동</a>
        </div>
	
		<div class="form-group">
            <label for="listSize">한 페이지당 게시물 수:</label>
            <select id="listSize" class="custom-select" onchange="movePage(this.value)">
                <option value="5" <c:if test="${param.listSize == 5}">selected</c:if>>5개</option>
                <option value="10" <c:if test="${param.listSize == 10}">selected</c:if>>10개</option>
                <option value="20" <c:if test="${param.listSize == 20}">selected</c:if>>20개</option>
                <option value="50" <c:if test="${param.listSize == 50}">selected</c:if>>50개</option>
            </select>
        </div>
        <table class="table table-bordered table-hover">
            <thead class="thead-dark">
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>내용</th>
                    <th>조회수</th>
                    <th>날짜</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="board">
                    <tr>
                        <td>${board.no}</td>
                        <td>
                            <a href="${path}/board/boardDetail?no=${board.no}">
                                ${board.title}
                            </a>
                        </td>
                        <td>${board.writer}</td>
                        <td>${board.content}</td>
                        <td>${board.viewCnt}</td>
                        <td>${board.regDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <nav class="d-flex justify-content-center">
            <ul class="pagination">
                <c:if test="${pr.prev}">
                    <li class="page-item">
                        <a class="page-link" href="boardList?page=1&listSize=${param.listSize}">첫 페이지</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="boardList?page=${pr.beginPage - 1}&listSize=${param.listSize}">이전</a>
                    </li>
                </c:if>
                <c:forEach var="i" begin="${pr.beginPage}" end="${pr.endPage}">
                    <li class="page-item <c:if test='${pr.page == i}'>active</c:if>">
                        <a class="page-link" href="boardList?page=${i}&listSize=${param.listSize}">${i}</a>
                    </li>
                </c:forEach>

                <c:if test="${pr.next}">
                    <li class="page-item">
                        <a class="page-link" href="boardList?page=${pr.endPage + 1}&listSize=${param.listSize}">다음</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="boardList?page=${pr.lastPage}&listSize=${param.listSize}">마지막 페이지</a>
                    </li>
                </c:if>
            </ul>
        </nav>

        <div class="custom-btn">
            <a href="${path}/board/boardInsert" class="btn btn-success">글 작성</a>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- MovePage -->
    <script>
    	function movePage(listSize) {
    		location.href="boardList?&listSize=" + listSize;
    	}
    </script>
</body>
</html>
