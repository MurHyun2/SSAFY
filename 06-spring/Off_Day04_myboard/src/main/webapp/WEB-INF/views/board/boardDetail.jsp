<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>게시물 상세보기</title>
    
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
        .table th, .table td {
            text-align: center;
            vertical-align: middle;
        }
        .image-preview {
            max-width: 600px;
            margin: 20px auto;
        }
        .image-preview img {
            width: 100%;
            height: auto;
        }
        .button-group {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>HELLO! DETAIL PAGE</h1>

        <div class="text-right mb-4">
            <a href="${path}/board/boardList" class="btn btn-primary">게시판 이동</a>
        </div>

        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>내용</th>
                    <th>조회수</th>
                    <th>날짜</th>
                    <th>첨부파일</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${board.no}</td>
                    <td>${board.title}</td>
                    <td>${board.writer}</td>
                    <td>${board.content}</td>
                    <td>${board.viewCnt}</td>
                    <td>${board.regDate}</td>
                    <td>
                        <c:if test="${not empty board.boardFile}">
                            <div class="image-preview">
                                <img src="${imagePath}" alt="Image" />
                            </div>
                            <a href="${path}/board/download?filePath=${board.boardFile.filePath}&systemName=${board.boardFile.systemName}" 
                               class="btn btn-outline-info">
                                ${board.boardFile.oriName}
                            </a>
                        </c:if>
                    </td>
                </tr>
            </tbody>
        </table>

        <div class="button-group">
            <a href="${path}/board/boardInsert" class="btn btn-success">입력창</a>
            <a href="${path}/board/boardUpdate?no=${board.no}" class="btn btn-warning">수정창</a>
            <form action="${path}/board/boardDelete?no=${board.no}" method="post" class="d-inline-block">
                <button type="submit" class="btn btn-danger">삭제</button>
            </form>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
