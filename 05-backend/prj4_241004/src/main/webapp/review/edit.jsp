<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
</head>
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

#reviewBtn {
	color: white;
	border-radius: 5px;
	border-color: rgb(0, 85, 255);
	background-color: rgb(0, 85, 255);
	height: 40px;
	width: 74px;
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
</style>
<body>
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">🦄운동영상
						리뷰🦄</h1>
					<!-- <button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button> -->
				</div>
				<form
					action="${pageContext.request.contextPath}/review?action=update&reviewNo=${review.reviewNo}&videoNo=${review.videoNo}"
					method="post">
					<div class="modal-body">

						<input type="text" id="editContent" name="content"
							value="${review.content}">
					</div>
					<div class="modal-footer">

						<%-- 	<input type="hidden" name="action" value="update"/> <!-- 수정 액션 -->
						  	<input type="hidden" name="reviewNo" value="${review.reviewNo}"/> <!-- 수정할 리뷰 번호 --> --%>
						<%--  <input type="text" id="updateContent" name="content" value="${review.content}"/> <!-- 내용 입력 --> --%>

						<button type="submit" class="btn btn-primary">수정</button>
						<!-- 수정 버튼 -->
				</form>
				
				<!-- 삭제 버튼 -->
				<form
					action="${pageContext.request.contextPath}/review?action=delete&reviewNo=${review.reviewNo}&videoNo=${review.videoNo}"
					method="post" style="display: inline;">
					<button type="submit" class="btn btn-danger"
						onclick="return confirm('정말 삭제하시겠습니까?');">삭제</button>
				</form>
			</div>
		</div>
	</div>
	</div>

	</div>



</body>
</html>
