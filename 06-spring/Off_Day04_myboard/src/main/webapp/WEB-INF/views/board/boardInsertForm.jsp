<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>게시물 입력</title>

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
        .form-container {
            max-width: 600px;
            margin: 50px auto;
            padding: 30px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .btn-group {
            display: flex;
            justify-content: space-between;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>HELLO! DETAIL PAGE</h1>

        <div class="text-right mb-4">
            <a href="${path}/board/boardList" class="btn btn-primary">게시판 이동</a>
        </div>

        <div class="form-container">
            <form action="${path}/board/boardInsert" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="title">제목</label>
                    <input type="text" id="title" name="title" class="form-control" required>
                </div>

                <div class="form-group">
                    <label for="writer">작성자</label>
                    <input type="text" id="writer" name="writer" class="form-control" required>
                </div>

                <div class="form-group">
                    <label for="content">내용</label>
                    <textarea id="content" name="content" class="form-control" rows="5" required></textarea>
                </div>

                <div class="form-group">
                    <label for="attach">파일 첨부</label>
                    <input type="file" id="attach" name="attach" class="form-control-file">
                </div>

                <div class="btn-group">
                    <button type="submit" class="btn btn-success">입력</button>
                    <button type="reset" class="btn btn-secondary">초기화</button>
                </div>
            </form>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
