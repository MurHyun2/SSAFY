<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<style>
.title {
	display: flex;
	justify-content: center;
	margin-top: 10px;
	font-size: 30px;
}

/***** 리뷰등록 모달 css *******/
.dialog {
	display: none;
	position: fixed;
	left: 0;
	top: 0;
	z-index: 10;
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0.4);
}

.dialog>.tb {
	display: flex;
	justify-content: center;
	align-items: center;
	width: 100%;
	height: 100%;
}

.dialog>.tb .inner {
	width: 100%;
	padding: 20px;
	background: #fff;
	border-radius: 16px;
}

.dialog .top {
	display: flex;
	align-item: center;
	border-bottom: 1px solid #ddd;
	justify-content: space-between;
	padding-bottom: 15px;
	margin-bottom: 15px;
}

.dialog .title {
	font-weight: bold;
	font-size: 20px;
}

.dialog .ct {
	max-height: 60vh;
	height: 60vh;
	overflow-y: auto;
	border-bottom-left-radius: 10px;
	border-bottom-right-radius: 10px;
	background-color: #fff;
}

/***** 리뷰등록 모달 css 끝*******/
input {
	display: flex;
	width: 100%;
	height: 15%;
	border-radius: 5px;
	margin-bottom: 20px;
}

#reviewTitle {
	width: 100%;
	height: 7%;
}

table, th, td {
	border: 1px solid #bcbcbc;
	height: 40px;
}

table {
	width: 95%;
	margin-left: 2.5%;
}

.th-2 {
	width: 50%;
}

.video {
	display: flex;
	justify-content: center;
}

.p_close {
	color: aquamarine;
}

#reg {
	color: rgb(3, 151, 209);
	border-radius: 5px;
	border-color: rgb(27, 113, 226);
	background-color: whitesmoke;
}

#can {
	color: rgb(243, 50, 36);
	border-radius: 5px;
	border-color: rgb(243, 50, 36);
	background-color: whitesmoke;
}

.search {
	width: 15%;
	height: 30px;
	font-size: 15px;
	border: none;
	border-bottom: 1px black solid;
}

.mainTop {
	display: flex;
	justify-content: space-between;
	margin-left: 3%;
	margin-right: 4%;
}

.inner>.top {
	display: flex;
	justify-content: center;
}

#reviewBtn {
    color: white;
    border-radius: 5px;
    border-color: rgb(0, 85, 255);
    background-color: rgb(0, 85, 255);
    height: 40px;
    width: 74px;
}

#backBtn {
    color: black;
    border-radius: 5px;
    border-color: gray;
    background-color: lightgray;
    height: 40px;
    width: 74px;
}
</style>
</head>
<body>
	<header>
		<div class="title">🦄운동영상 리뷰🦄</div>
		<hr>
	</header>

	<main>
		<div class="video">
			<iframe width="560" height="315" src="${videoURL}"
				title="YouTube video player" frameborder="0"
				allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
				referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
		</div>

		<hr>
		<div class="mainTop">
			<!-- 글 작성 버튼 -->
			<form
				action="${pageContext.request.contextPath}/review?action=writeForm&videoNo=${videoNo}"
				method="post">
				<button type="submit" id="reviewBtn">글작성</button>
			</form>

			<!-- 뒤로가기 버튼 -->
			<button type="button" id="backBtn" onclick="goBack()">뒤로가기</button>
		</div>
		<hr>

		<table>
			<thead>
				<th>번호</th>
				<th class="th-2">내용</th>
				<th>작성자</th>
				<!-- <th>조회수</th> -->
				<th>작성시간</th>

			</thead>

			<tbody>
				<!--영상에 대한 전체 영상 가져오기. (반복문 돌면서 전체 가져오기)-->
				<c:forEach var="review" items="${reviews}">
					<tr>
						<td>${review.reviewNo}</td>
						<td class="tableTitle"><c:if
								test="${review.writer == sessionScope.member.nickName}">
								<a
									href="${pageContext.request.contextPath}/review?action=updateForm&reviewNo=${review.reviewNo}">${review.content}</a>
							</c:if> <c:if test="${review.writer != sessionScope.member.nickName}">
			                ${review.content} <!-- 수정 권한이 없는 경우 링크가 아닌 텍스트로 표시 -->
							</c:if></td>
						<td>${review.writer}</td>
						<td>${review.regDate}</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>


		<div id="modal" class="dialog">
			<div class="tb">
				<div class="inner" style="max-width: 800px;"">
					<div class=" top">
						<div class="title">🦄운동영상 리뷰🦄</div>
						<!-- <a href="#" class="p_close">닫기</a> -->
					</div>
					<div class="ct">
						<form action="${pageContext.request.contextPath}/review"
							method="post"">
							<input type="hidden" name="action" value="write" /> <input
								type="text" id="reviewTitle" placeholder="제목"> <input
								type="text" placeholder="내용을 입력해주세요"> <input type="text"
								placeholder="작성" name="writer">
							<button id="reg">등록</button>
							<button id="can" oneclick="">취소</button>
					</div>
				</div>
			</div>
		</div>

		<p></p>
		</table>
		<script type="text/javascript">
			function goBack() {
				window.history.back();
			}
		</script>
</body>
</html>
