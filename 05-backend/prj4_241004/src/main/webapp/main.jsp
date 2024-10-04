<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>

<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@700&display=swap"
	rel="stylesheet">
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>

<style>
/* 폰트 스타일 개선 */
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: #f4f5f7;
	color: #2c3e50;
	line-height: 1.6;
	margin: 0;
	padding: 0;
}

/* 네비게이션 바 스타일 개선 */
.navbar {
	background-color: #212529;
	border-bottom: 3px solid #ffcd39;
	border-radius: 10px;
	display: flex;
	justify-content: center;
	padding: 1rem 2rem;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.15);
}

/* SSAFIT 로고 스타일 */
.navbar a.navbar-brand {
	font-size: 4rem; /* 크기 조정 (더 크게 설정) */
	color: #ffc107;
	text-decoration: none;
	font-weight: bold;
	letter-spacing: 2px;
	font-family: 'Roboto', sans-serif; /* 현대적인 폰트 적용 */
}

.navbar a.navbar-brand:hover {
	color: #ffea82; /* 호버 시 강조 */
}

/* 밑의 글귀 스타일 */
.navbar p {
	font-size: 1.5rem; /* 크기 조정 (더 크게 설정) */
	color: #f8f9fa; /* 글자 색상 변경 */
	font-family: 'Roboto', sans-serif; /* 현대적인 폰트 적용 */
}

/* 카드 박스 스타일 개선 */
.card-box {
	display: flex;
	flex-wrap: wrap; /* 카드가 줄바꿈 할 수 있도록 설정 */
	justify-content: center; /* 가운데 정렬 */
	max-width: calc(6 * 18rem + 40px); /* 카드 5개 + 여백 계산 (10px 여백 * 4개) */
	margin: 1rem auto; /* 위 아래 여백 추가, 가운데 정렬 */
	gap: 20px; /* 카드 간의 간격 조정 */
	padding: 2rem; /* 전체 패딩 추가 */
	transition: opacity 0.3s ease; /* 부드러운 전환 효과 */
}

/* 카드 스타일 개선 */
.card {
	margin: 10px; /* 카드 간의 간격 */
	border-radius: 15px;
	width: 18rem; /* 카드의 고정 너비 설정 */
	box-sizing: border-box; /* 패딩 및 마진을 포함하여 너비 계산 */
	background-color: #ffffff; /* 밝은 배경으로 가독성 향상 */
	box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1); /* 더 부드럽고 큰 그림자 추가 */
	transition: transform 0.3s ease, box-shadow 0.3s ease; /* 호버 시 애니메이션 */
	overflow: hidden; /* 카드가 넘치지 않도록 설정 */
}

/* 각 카드의 호버 효과 */
.card:hover {
	transform: scale(1.07); /* 호버 시 확대 효과 */
	box-shadow: 0px 12px 20px rgba(0, 0, 0, 0.2); /* 호버 시 그림자 증가 */
}

/* 반응형 카드 크기 조정 */
@media ( max-width : 768px) {
	.card {
		width: calc(50% - 20px); /* 작은 화면에서 2개씩 배치 */
	}
}

@media ( max-width : 480px) {
	.card {
		width: calc(100% - 20px); /* 더 작은 화면에서 1개씩 배치 */
	}
}

/* iframe 스타일 개선 */
iframe {
	border-radius: 20px;
	width: 100%; /* iframe을 카드의 너비에 맞게 조정 */
	aspect-ratio: 16/9; /* 비율 유지 */
	border: none; /* 기본 테두리 제거 */
}

/* 버튼 스타일 개선 */
.btn {
	margin-left: 5px;
	margin-right: 5px;
}

/* 모달 창 스타일 개선 */
.modal {
	color: #2c3e50;
	border-radius: 20px;
	padding: 2rem; /* 내부 여백 추가 */
	box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.2); /* 그림자 추가 */
}
/* 캐러셀 아이템 스타일 개선 */
.carousel-item img {
	height: 600px; /* 최대 높이를 600px로 설정 */
	width: 100%; /* 너비를 부모 요소에 맞추어 100%로 설정 */
	object-fit: cover; /* 이미지 비율을 유지하며 영역을 채움 */
	border-radius: 15px; /* 이미지 모서리를 둥글게 */
	margin: 0 auto; /* 중앙 정렬 */
}

/* 콘텐츠 헤더 스타일 개선 */
.content-header {
	display: flex;
	flex-direction: column; /* 세로 정렬 */
	align-items: center; /* 가운데 정렬 */
	padding: 2rem; /* 상하 여백 추가 */
	background-color: #adb5bd; /* 어두운 배경색 */
	border-radius: 10px; /* 모서리 둥글게 */
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3); /* 그림자 효과 추가 */
}

/* 제목 스타일 개선 */
.content-header h2 {
	color: #ffc107; /* 제목 색상 (노란색) */
	font-size: 2.5rem; /* 제목 크기 조정 */
	margin-bottom: 0.5rem; /* 제목 아래 여백 추가 */
}

/* 부제목 스타일 개선 */
.content-header p {
	color: #b0b3b8; /* 부제목 색상 (회색) */
	font-size: 1.2rem; /* 부제목 크기 조정 */
}

/* 버튼 스타일 개선 */
#register-video-btn {
	background-color: #f8f9fa; /* 밝은 배경색 */
	color: #343a40; /* 어두운 글자색 */
	border: 2px solid #ced4da; /* 밝은 테두리 추가 */
	padding: 10px 20px; /* 패딩 */
	font-size: 1.1rem; /* 글자 크기 */
	transition: background-color 0.3s ease, transform 0.2s ease, box-shadow
		0.3s ease; /* 애니메이션 효과 */
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
}

#register-video-btn:hover {
	background-color: #e2e6ea; /* 호버 시 색상 변화 */
	transform: translateY(-2px); /* 호버 시 약간 떠오르는 효과 */
}

#register-video-btn:active {
	transform: translateY(0); /* 클릭 시 원래 위치로 복원 */
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2); /* 클릭 시 그림자 감소 */
}

/* 반응형 처리 - 작은 화면일 때 간격 조정 */
@media ( max-width : 768px) {
	.navbar {
		padding: 0.5rem; /* 모바일에서 상하 패딩 줄이기 */
	}
	.content-header {
		padding: 0.5rem 1rem; /* 상하 및 좌우 패딩 줄이기 */
	}
	.carousel-item img {
		height: 400px; /* 모바일에서 이미지 높이 줄이기 */
	}
}

#resultMessage {
	text-align: center; /* 텍스트 가운데 정렬 */
	border-radius: 8px; /* 둥근 모서리 */
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* 부드러운 그림자 효과 */
	background-color: #f0f9ff; /* 부드러운 배경색 */
	color: #0d6efd; /* 텍스트 색상 */
	padding: 15px; /* 패딩 추가 */
	margin: 15px 0; /* 위아래 여백 추가 */
	font-size: 17px; /* 글자 크기 */
}

.modal-title {
	font-weight: bold;
	color: #333;
}
</style>
</head>
<body>
	<div class="text-bg-dark p-3">
		<header style="width: 70%; margin: 0 auto;">
			<nav
				class="navbar navbar-expand-lg navbar-dark bg-dark border-bottom border-body py-3"
				data-bs-theme="dark">
				<div class="container d-flex flex-column align-items-center">
					<!-- SSAFIT Logo and Title -->
					<a class="navbar-brand" href="#video-section"
						style="letter-spacing: 3px;"> SSAFIT </a>
					<!-- Centered Tagline -->
					<p class="text-center text-white mt-2 mb-0">
						<em>"Unlock Your Potential with Expert Fitness Video Reviews"</em>
					</p>
					<!-- Toggler for Mobile View -->
					<button class="navbar-toggler mt-2" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
						aria-controls="navbarNavDropdown" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<!-- Navigation Menu -->
					<div class="collapse navbar-collapse justify-content-center mt-3"
						id="navbarNavDropdown">
						<ul class="navbar-nav">
							<c:choose>
								<c:when test="${sessionScope.member.id == 'guest'}">
									<!-- Guest 로그인 및 회원가입 버튼 -->
									<li class="nav-item me-3">
										<button type="button" id="main-login-btn"
											class="btn btn-outline-light" data-bs-toggle="modal"
											data-bs-target="#loginModal" data-bs-whatever="@mdo">
											<i class="fas fa-sign-in-alt"></i> Login
										</button>
									</li>
									<li class="nav-item"><a class="btn btn-outline-light"
										href="#" id="signIn-a" data-bs-toggle="modal"
										data-bs-target="#signInModal" data-bs-whatever="@mdo">
											Sign Up </a></li>
								</c:when>
								<c:otherwise>
									<!-- 로그인된 사용자 로그아웃 버튼 -->
									<li class="nav-item"><a
										href="${pageContext.request.contextPath}/member?action=logout"
										id="main-logout-link" class="btn btn-outline-light"> <i
											class="fas fa-sign-out-alt"></i> Logout
									</a></li>
									<!-- 드롭다운 메뉴 -->
									<li class="nav-item dropdown ms-3"><a
										class="nav-link dropdown-toggle text-light" href="#"
										role="button" data-bs-toggle="dropdown" aria-expanded="false">
											Menu </a>
										<ul class="dropdown-menu">
											<li><a class="dropdown-item text-light text-opacity-75"
												style="pointer-events: none; cursor: default;">${sessionScope.member.nickName }
													님</a></li>
											<li><a class="dropdown-item" data-bs-toggle="modal"
												data-bs-target="#memberInfoModal" style="cursor: default;">
													회원 정보 </a></li>
											<li><a class="dropdown-item text-danger"
												data-bs-toggle="modal" data-bs-target="#deleteMemberModal"
												style="cursor: default;"> 회원 탈퇴 </a></li>
											<li><a class="dropdown-item text-danger"
												data-bs-toggle="modal"
												data-bs-target="#customerSupportModal"> 고객 문의 </a></li>
										</ul></li>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>
				</div>
			</nav>
		</header>
		<main style="width: 70%; margin: 0 auto;">
			<br>
			<introduce> <%-- 결과 메시지 표시 --%> <c:if
				test="${not empty resultMessage}">
				<div id="resultMessage"
					class="alert alert-dismissible fade show text-center" role="alert"
					style="border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); background-color: #f0f9ff; color: #0d6efd;">
					${resultMessage}
					<button type="button" class="btn-close" data-bs-dismiss="alert"
						aria-label="Close"></button>
				</div>
			</c:if>
			<div id="carouselExampleIndicators" class="carousel slide">
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="0" class="active" aria-current="true"
						aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="1" aria-label="Slide 2"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="2" aria-label="Slide 3"></button>
				</div>
				<!-- style="justify-content: center; width: 50%;" -->
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="./img/사진1.jpg" class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="./img/사진2.jpg" class="d-block w-100" alt="...">
					</div>
					<div class="carousel-item">
						<img src="./img/사진3.jpg" class="d-block w-100" alt="...">
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
			</introduce>
			<br>
			<div class="content-header">
				<h2 class="text-center text-dark fw-bold"
					style="font-size: 2.5rem; letter-spacing: 1.5px;">Unlock Your
					Fitness Journey</h2>
				<p class="text-center text-muted" style="font-size: 1.2rem;">Explore
					our handpicked selection of fitness videos</p>
				<c:if test="${sessionScope.member.id == 'admin'}">
					<div>
						<button type="button" id="register-video-btn"
							class="btn btn-primary rounded-pill fw-bold"
							data-bs-toggle="modal" data-bs-target="#insertModal"
							data-bs-whatever="@mdo">
							<i class="fas fa-plus-circle"></i> 동영상 등록
						</button>
					</div>
				</c:if>
				<div>
					<!-- 일반 회원일 경우 토글 버튼을 보여줌 -->
					<c:if test="${sessionScope.member.id != 'admin'}">
						<div class="toggle-buttons">
							<button class="btn btn-outline-primary active" id="showRandom"
								onclick="showRandomVideos()">추천 영상 보기</button>
							<button class="btn btn-outline-secondary" id="showAll"
								onclick="showAllVideos()">전체 영상 보기</button>
						</div>
					</c:if>
				</div>
			</div>
			<!-- ----------------------------운동 카드 목록 START-------------------------------- -->
			<div id="video-section" class="card-box">
				<c:choose>
					<c:when test="${sessionScope.member.id == 'admin'}">
						<c:forEach items="${listAll}" var="video">
							<div class="card">
								<iframe width="100%" height="315" src="${video.videoURL}"
									title="YouTube video player" frameborder="0"
									allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
									referrerpolicy="strict-origin-when-cross-origin"
									allowfullscreen></iframe>
								<div class="card-body">
									<h5 class="card-title">${video.videoTitle}</h5>
								</div>
								<ul class="list-group list-group-flush">
									<li class="list-group-item">운동 주제: ${video.category}</li>
									<li class="list-group-item">운동 부위: ${video.part}</li>
									<li class="list-group-item">채널명: ${video.channelName}</li>
								</ul>
								<div
									class="card-body d-flex justify-content-between align-items-center">
									<form action="${pageContext.request.contextPath}/review"
										style="margin-right: auto;">
										<input type="hidden" name="action" value="list"> <input
											type="hidden" name="videoNo" value="${video.videoNo}">
										<input type="hidden" name="videoURL" value="${video.videoURL}">
										<button class="btn btn-outline-dark">리뷰</button>
									</form>
									<div>
										<button type="button"
											class="btn btn-outline-primary update-btn"
											data-bs-toggle="modal" data-bs-target="#updateModal"
											data-video-no="${video.videoNo}" data-url="${video.videoURL}"
											data-title="${video.videoTitle}"
											data-exercise-topic="${video.category}"
											data-exercise-area1="${video.part}"
											data-channel-name="${video.channelName}">수정</button>
										<form action="${pageContext.request.contextPath }/board"
											method="post" style="display: inline;"
											onsubmit="return confirmDelete();">
											<input type="hidden" name="action" value="delete"> <input
												type="hidden" name="videoNo" value="${video.videoNo}">
											<button type="submit" class="btn btn-outline-danger">삭제</button>
										</form>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<div class="card-box" id="randomVideos">
							<c:forEach items="${listRandom}" var="video">
								<div class="card">
									<iframe width="100%" height="315" src="${video.videoURL}"
										title="YouTube video player" frameborder="0"
										allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
										referrerpolicy="strict-origin-when-cross-origin"
										allowfullscreen></iframe>
									<div class="card-body">
										<h5 class="card-title">${video.videoTitle}</h5>
									</div>
									<ul class="list-group list-group-flush">
										<li class="list-group-item">운동 주제: ${video.category}</li>
										<li class="list-group-item">운동 부위: ${video.part}</li>
										<li class="list-group-item">채널명: ${video.channelName}</li>
									</ul>
									<div class="card-body">
										<form action="${pageContext.request.contextPath}/review">
											<button class="btn btn-outline-primary work-out-btn"
												type="button" onclick="window.open('${video.videoURL}')">운동하기</button>
											<input type="hidden" name="action" value="list"> <input
												type="hidden" name="videoNo" value="${video.videoNo}">
											<input type="hidden" name="videoURL"
												value="${video.videoURL}">
											<button class="btn btn-outline-dark">리뷰</button>
										</form>
									</div>
								</div>
							</c:forEach>
						</div>

						<div class="card-box" id="allVideos" style="display: none;">
							<c:forEach items="${listAll}" var="video2">
								<div class="card">
									<iframe width="100%" height="315" src="${video2.videoURL}"
										title="YouTube video player" frameborder="0"
										allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
										referrerpolicy="strict-origin-when-cross-origin"
										allowfullscreen></iframe>
									<div class="card-body">
										<h5 class="card-title">${video2.videoTitle}</h5>
									</div>
									<ul class="list-group list-group-flush">
										<li class="list-group-item">운동 주제: ${video2.category}</li>
										<li class="list-group-item">운동 부위: ${video2.part}</li>
										<li class="list-group-item">채널명: ${video2.channelName}</li>
									</ul>
									<div class="card-body">
										<form action="${pageContext.request.contextPath}/review">
											<button class="btn btn-outline-primary work-out-btn"
												type="button" onclick="window.open('${video2.videoURL}')">운동하기</button>
											<input type="hidden" name="action" value="list"> <input
												type="hidden" name="videoNo" value="${video2.videoNo}">
											<input type="hidden" name="videoURL"
												value="${video2.videoURL}">
											<button class="btn btn-outline-dark">리뷰</button>
										</form>
									</div>
								</div>
							</c:forEach>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			<!-- ----------------------------운동 카드 목록 END-------------------------------- -->

			<!-- 로그인 모달창 -->
			<div class="modal fade" id="loginModal" tabindex="-1"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h1 class="modal-title fs-5" id="exampleModalLabel">로그인</h1>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<form id="loginForm"
								action="${pageContext.request.contextPath}/member" method="post">
								<input type="hidden" name="action" value="login" />
								<div class="mb-3">
									<label for="recipient-name" class="col-form-label">아이디:</label>
									<input type="text" class="form-control" id="loginId" name="id"
										required>
								</div>
								<div class="mb-3">
									<label for="message-text" class="col-form-label">패스워드:</label>
									<input type="password" class="form-control" id="loginPw"
										name="password" required>
								</div>
								<div class="modal-footer">
									<button type="submit" class="btn btn-primary">Login</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>

			<!-- 회원가입 모달창 -->
			<div class="modal fade" id="signInModal" tabindex="-1"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h1 class="modal-title fs-5" id="exampleModalLabel">회원가입</h1>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<form method="post"
								action="${pageContext.request.contextPath}/member"
								onsubmit="return validateForm()">
								<input type="hidden" name="action" value="register" />
								<div class="mb-3">
									<label for="signInId" class="col-form-label">■ 아이디:</label> <input
										type="text" class="form-control" id="signInId" name="id"
										required placeholder="아이디를 입력하세요">
								</div>
								<div class="mb-3">
									<label for="signInPw" class="col-form-label">■ 패스워드:</label> <input
										type="password" class="form-control" id="signInPw"
										name="password" required placeholder="비밀번호를 입력하세요">
								</div>
								<div class="mb-3">
									<label for="signInPw2" class="col-form-label">■ 패스워드
										확인:</label> <input type="password" class="form-control" id="signInPw2"
										required placeholder="비밀번호 확인" oninput="checkPasswordMatch()">
									<div id="passwordMessage" class="text-danger mt-2"
										style="display: none;"></div>
									<!-- 메시지 표시용 div -->
								</div>
								<div class="mb-3">
									<label for="name" class="col-form-label">■ 이름:</label> <input
										type="text" class="form-control" id="name" name="name"
										required placeholder="이름을 입력하세요">
								</div>
								<div class="mb-3">
									<label for="nickName" class="col-form-label">■ 닉네임:</label> <input
										type="text" class="form-control" id="nickName"
										name="nick_name" required placeholder="닉네임을 입력하세요">
								</div>
								<div class="mb-3">
									<label for="recipient-name" class="col-form-label">■
										전화번호:</label> <input type="text" class="form-control" id="cellPhone"
										name="phone" placeholder="010-1234-1234" maxlength="13"
										required onkeyup="formatPhoneNumber(event)">
								</div>
								<div class="mb-3">
									<label for="zipp_code_id" class="form-label">■ 주소</label>
									<div class="d-flex">
										<input type="text" class="form-control" id="zipp_code_id"
											name="zip_code" maxlength="10" placeholder="우편번호" required
											style="width: 50%;">
										<button type="button" id="zipp_btn"
											class="btn btn-primary ms-2" onclick="execDaumPostcode()">우편번호
											찾기</button>
									</div>
									<input type="text" class="form-control mb-2 mt-2"
										name="user_add1" id="UserAdd1" maxlength="40"
										placeholder="기본 주소를 입력하세요" required> <input
										type="text" class="form-control" name="user_add2"
										id="UserAdd2" maxlength="40" placeholder="상세 주소를 입력하세요">
								</div>
								<div class="modal-footer">
									<button type="submit" class="btn btn-primary w-100">회원가입</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>

			<!-- 회원 정보 모달창 -->
			<div class="modal fade" id="memberInfoModal" tabindex="-1"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h1 class="modal-title fs-5" id="exampleModalLabel">회원 정보</h1>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<form method="post"
								action="${pageContext.request.contextPath}/member"
								onsubmit="return validateForm()">
								<input type="hidden" name="action" value="update" /> <input
									type="hidden" name="id" value="${sessionScope.member.id}" />
								<div class="mb-3">
									<label for="signInId" class="col-form-label">■ 아이디:</label> <input
										type="text" class="form-control" id="memberUpdateId"
										value="${sessionScope.member.id}"
										style="background-color: #f0f0f0;" readonly>
								</div>
								<div class="mb-3">
									<label for="existingPw" class="col-form-label">■ 비밀번호:</label>
									<input type="password" class="form-control" id="existingPw"
										required placeholder="기존 비밀번호를 입력하세요">
								</div>
								<div class="mb-3">
									<label for="name" class="col-form-label">■ 이름:</label> <input
										type="text" class="form-control" id="name" name="name"
										value="${sessionScope.member.name}" required>
								</div>
								<div class="mb-3">
									<label for="nickName" class="col-form-label">■ 닉네임:</label> <input
										type="text" class="form-control" id="nickName"
										name="nick_name" required
										value="${sessionScope.member.nickName}">
								</div>
								<div class="mb-3">
									<label for="cellPhone" class="col-form-label">■ 전화번호:</label> <input
										type="text" class="form-control" id="cellPhone" name="phone"
										value="${sessionScope.member.phoneNum}" maxlength="13"
										required onkeyup="formatPhoneNumber(event)">
								</div>
								<div class="mb-3">
									<label for="zipp_code_id" class="form-label">■ 주소</label>
									<div class="d-flex">
										<input type="text" class="form-control"
											id="update_zipp_code_id" name="zip_code" maxlength="10"
											value="${sessionScope.member.addrNum}" required
											style="width: 50%;">
										<button type="button" id="zipp_btn"
											class="btn btn-primary ms-2"
											onclick="updateExecDaumPostcode()">우편번호 찾기</button>
									</div>
									<input type="text" class="form-control mb-2 mt-2"
										name="user_add1" id="updateUserAdd1" maxlength="40"
										value="${sessionScope.member.addrBasic}" required> <input
										type="text" class="form-control" name="user_add2"
										id="updateUserAdd2" maxlength="40"
										value="${sessionScope.member.addrDetail}">
								</div>
								<div class="modal-footer">
									<button type="submit" class="btn btn-primary w-100"
										onclick="return validateExistingPassword()">수정</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>

			<!-- 수정 모달창 -->
			<div class="modal fade" id="updateModal" tabindex="-1"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h1 class="modal-title fs-5" id="exampleModalLabel">영상 수정</h1>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<form method="post"
								action="${pageContext.request.contextPath }/board">
								<input type="hidden" name="action" value="update" /> <input
									type="hidden" id="updateVideoNo" name="videoNo" />
								<div class="mb-3">
									<label for="recipient-name" class="col-form-label">■
										URL:</label> <input type="text" class="form-control" id="updateURL"
										name="videoURL">
								</div>
								<div class="mb-3">
									<label for="message-text" class="col-form-label">■ 제목:</label>
									<input type="text" class="form-control" id="updateTitle"
										name="videoTitle">
								</div>
								<div class="mb-3">
									<label for="message-text" class="col-form-label">■ 운동
										주제:</label> <input type="text" class="form-control"
										id="updateCategory" name="category">
								</div>
								<div class="mb-3">
									<label for="message-text" class="col-form-label">■ 운동
										부위:</label> <input type="text" class="form-control" id="updatePart"
										name="part">
								</div>
								<div class="mb-3">
									<label for="message-text" class="col-form-label">■ 채널명:</label>
									<input type="text" class="form-control" id="updateChannelName"
										name="channelName">
								</div>
								<div class="modal-footer">
									<button type="submit" class="btn btn-primary" id="updateBtn">수정</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>

			<!-- 등록 모달창 -->
			<div class="modal fade" id="insertModal" tabindex="-1"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h1 class="modal-title fs-5" id="exampleModalLabel">영상 등록</h1>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<form method="post"
								action="${pageContext.request.contextPath }/board">
								<input type="hidden" name="action" value="insert" />
								<div class="mb-3">
									<label for="recipient-name" class="col-form-label">■
										URL:</label> <input type="text" class="form-control" id="insertURL"
										name="videoURL">
								</div>
								<div class="mb-3">
									<label for="message-text" class="col-form-label">■ 제목:</label>
									<input type="text" class="form-control" id="insertTitle"
										name="videoTitle">
								</div>
								<div class="mb-3">
									<label for="message-text" class="col-form-label">■ 운동
										주제:</label> <input type="text" class="form-control"
										id="insertCategory" name="category">
								</div>
								<div class="mb-3">
									<label for="message-text" class="col-form-label">■ 운동
										부위:</label> <input type="text" class="form-control" id="insertPart"
										name="part">
								</div>
								<div class="mb-3">
									<label for="message-text" class="col-form-label">■ 채널명:</label>
									<input type="text" class="form-control" id="insertChannelName"
										name="channelName">
								</div>
								<div class="modal-footer">
									<button type="submit" class="btn btn-primary" id="insertBtn">등록</button>
									<button type="reset" class="btn btn-outline-dark">초기화</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>

			<!-- 회원 탈퇴 확인 모달 -->
			<div class="modal fade" id="deleteMemberModal" tabindex="-1"
				aria-labelledby="deleteMemberModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title text-danger" id="deleteMemberModalLabel">회원
								탈퇴 확인</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">
							정말로 회원 탈퇴를 하시겠습니까?<br> 탈퇴하시면 계정 정보는 복구할 수 없습니다.
						</div>
						<div class="modal-footer">
							<form id="deleteMemberForm"
								action="${pageContext.request.contextPath}/member" method="post"
								style="display: inline;">
								<input type="hidden" name="action" value="delete">
								<button type="submit" class="btn btn-outline-danger"
									id="deleteMemberBtn">회원 탈퇴</button>
							</form>
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">취소</button>
						</div>
					</div>
				</div>
			</div>
			<!-- 고객 문의 모달 창 -->
			<div class="modal fade" id="customerSupportModal" tabindex="-1"
				aria-labelledby="customerSupportModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="customerSupportModalLabel">고객 문의</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<!-- 고객 문의 모달 내용 -->
							<div class="container-fluid">
								<!-- 문의 목록 -->
								<div id="inquiry-list-section">
									<h5>문의 목록</h5>
									<c:if test="${not empty sessionScope.inquiryList}">
										<table class="table table-hover">
											<thead>
												<tr>
													<th>문의 ID</th>
													<th>제목</th>
													<th>상태</th>
													<th>관리</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="inquiry" items="${sessionScope.inquiryList}">
													<tr>
														<td>${inquiry.inquiryId}</td>
														<td><a
															href="${pageContext.request.contextPath}/inquiry?action=view&inquiryId=${inquiry.inquiryId}">${inquiry.title}</a></td>
														<td>${inquiry.status}</td>
														<td>
															<!-- 자신이 작성한 문의일 때만 삭제 버튼 표시 --> <c:if
																test="${inquiry.memberId == sessionScope.member.id}">
																<form
																	action="${pageContext.request.contextPath}/inquiry"
																	method="post" style="display: inline;"
																	onsubmit="return confirmDeleteInquiry();">
																	<input type="hidden" name="action" value="delete">
																	<input type="hidden" name="inquiryId"
																		value="${inquiry.inquiryId}">
																	<button type="submit" class="btn btn-danger btn-sm">삭제</button>
																</form>
															</c:if>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</c:if>
									<c:if test="${empty sessionScope.inquiryList}">
										<p>등록된 문의가 없습니다.</p>
									</c:if>
								</div>

								<!-- 문의 상세 내용 -->
								<div id="inquiry-details-section" class="mt-4">
									<h5>문의 상세 내용</h5>
									<c:if test="${not empty sessionScope.selectedInquiry}">
										<table class="table table-bordered">
											<tr>
												<th>문의 ID</th>
												<td>${selectedInquiry.inquiryId}</td>
											</tr>
											<tr>
												<th>제목</th>
												<td>${selectedInquiry.title}</td>
											</tr>
											<tr>
												<th>내용</th>
												<td>${selectedInquiry.message}</td>
											</tr>
											<tr>
												<th>상태</th>
												<td>${selectedInquiry.status}</td>
											</tr>
											<tr>
												<th>작성자</th>
												<td>${selectedInquiry.memberId}</td>
											</tr>
										</table>
									</c:if>
									<c:if test="${empty sessionScope.selectedInquiry}">
										<p>문의 상세 정보가 없습니다. 목록에서 제목을 클릭하여 문의 내용을 확인하세요.</p>
									</c:if>
								</div>

								<!-- 문의 작성 폼 -->
								<div id="inquiry-create-section" class="mt-4">
									<h5>문의 작성</h5>
									<form id="customerSupportForm"
										action="${pageContext.request.contextPath}/inquiry?action=create"
										method="post">
										<div class="mb-3">
											<label for="inquiryTitle" class="form-label">제목</label> <input
												type="text" class="form-control" id="inquiryTitle"
												name="title" placeholder="문의 제목을 입력하세요" required>
										</div>
										<div class="mb-3">
											<label for="inquiryMessage" class="form-label">문의 내용</label>
											<textarea class="form-control" id="inquiryMessage"
												name="message" rows="5" placeholder="문의 내용을 입력하세요" required></textarea>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-bs-dismiss="modal">닫기</button>
											<button type="submit" class="btn btn-primary"
												id="inquirySubmitBtn">문의 보내기</button>
										</div>
									</form>
								</div>

							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="mo	dal">닫기</button>
						</div>
					</div>
				</div>
			</div>
			<script>
				// 추천 영상을 보여주는 함수
				function showRandomVideos() {
				    document.getElementById('randomVideos').style.display = 'flex';
				    document.getElementById('allVideos').style.display = 'none';
				    
				    // 활성화된 버튼 클래스 토글
				    document.getElementById('showRandom').classList.add('active');
				    document.getElementById('showAll').classList.remove('active');
				}
	
				// 전체 영상을 보여주는 함수
				function showAllVideos() {
				    document.getElementById('randomVideos').style.display = 'none';
				    document.getElementById('allVideos').style.display = 'flex';
				    
				    // 활성화된 버튼 클래스 토글
				    document.getElementById('showAll').classList.add('active');
				    document.getElementById('showRandom').classList.remove('active');
				}
			    
				// 기존 비밀번호 확인 함수
			    function validateExistingPassword() {
			        const existingPassword = document.getElementById('existingPw').value;
			        const actualExistingPassword = "${sessionScope.member.password}"; // 서버에서 가져온 비밀번호
			        
			        if (existingPassword !== actualExistingPassword) {
			            alert('비밀번호가 일치하지 않습니다.');
			            document.getElementById('existingPw').value = "";
			            /* document.getElementById('newPw').value = "";
			            document.getElementById('newPw2').value = ""; */
			            document.getElementById('existingPw').focus(); // 기존 비밀번호 입력 필드로 포커스 이동
			            return false; // 폼 전송을 막음
			        }
			        return true; // 폼 전송 허용
			    }
			
			 	// 로그인 메시지가 3초 후에 사라지도록 설정
		        $(document).ready(function() {
		            setTimeout(function() {
		                $('#resultMessage').alert('close'); // Bootstrap의 alert 닫기 기능 사용
		            }, 3000); // 3000 밀리초 = 3초
		        });
			 	
                // btn-close 함수
                const closeBtn = document.querySelector('.btn-close');
                closeBtn.addEventListener('click', () => {
                    document.getElementById('loginId').value = "";
                    document.getElementById('loginPw').value = "";
                })

                const btn = document.getElementById('loginBtn');
                const mLoginBtn = document.getElementById('main-login-btn');
                const mLogoutBtn = document.getElementById('main-logout-btn');
                const signInA = document.getElementById('signIn-a');
                
                // 삭제 버튼 처리
                function confirmDelete() {
                    return confirm("이 비디오를 정말 삭제하시겠습니까?");
                }
                
             	// 회원 문의 삭제 confirm
                function confirmDeleteInquiry() {
                    return confirm("이 문의를 정말 삭제하시겠습니까?");
                }
                
                //수정 함수
				document.addEventListener('DOMContentLoaded', function () {
				    const updateButtons = document.querySelectorAll('.update-btn');
				
				    updateButtons.forEach(button => {
				        button.addEventListener('click', function() {
				            // 클릭된 버튼의 데이터 속성 가져오기
				            const videoNo = this.getAttribute('data-video-no');
				            const url = this.getAttribute('data-url');
				            const title = this.getAttribute('data-title');
				            const category = this.getAttribute('data-exercise-topic');
				            const part = this.getAttribute('data-exercise-area1'); // 운동 부위
				            const channelName = this.getAttribute('data-channel-name');
				
				            // 모달의 입력 필드에 값 설정
				            document.getElementById('updateVideoNo').value = videoNo; // 비디오 번호
				            document.getElementById('updateURL').value = url;
				            document.getElementById('updateTitle').value = title;
				            document.getElementById('updateCategory').value = category;
				            document.getElementById('updatePart').value = part;
				            document.getElementById('updateChannelName').value = channelName;
				        });
				    });
					
				});

                // 로그아웃 함수
                document.getElementById('main-logout-link').addEventListener('click', (event) => {
				    if (!confirm("Logout 하시겠습니까?")) {
				        event.preventDefault(); // 사용자가 취소한 경우 링크 이동을 막음
				    } else {
				        alert("Logout 성공!");
				    }
				});
                
                // 회원가입시 비밀번호 검증
                function checkPasswordMatch() {
				    const password = document.getElementById('signInPw').value;
				    const confirmPassword = document.getElementById('signInPw2').value;
				    const messageDiv = document.getElementById('passwordMessage');
				
				    // 기본적으로 메시지를 숨김
				    messageDiv.style.display = "none";
				
				    if (password === "" || confirmPassword === "") {
				        messageDiv.style.display = "none"; // 입력값이 없을 때 메시지 숨김
				        return; // 비밀번호가 입력되지 않은 경우 함수 종료
				    }
				
				    if (password !== confirmPassword) {
				        messageDiv.textContent = "비밀번호가 일치하지 않습니다.";
				        messageDiv.className = "text-danger error-message"; // 에러 클래스 추가
				    } else {
				        messageDiv.textContent = "비밀번호가 일치합니다.";
				        messageDiv.className = "text-success success-message"; // 성공 클래스 추가
				    }
				
				    messageDiv.style.display = "block"; // 메시지 표시
				}
                
                // 회원가입 함수
                const signUpBtn = document.getElementById('signUpBtn');

                signUpBtn.addEventListener('click', () => {
                    const signInPw = document.getElementById('signInPw');
                    const signInPw2 = document.getElementById('signInPw2');
                    const signInId = document.getElementById('signInId');

                    console.log(signInPw);
                    console.log(signInPw2);

                    if (signInPw.value == signInPw2.value) {
                        alert(`회원가입 성공! ${signInId.value}님 환영합니다. `)
                    } else {
                        alert("비밀번호를 확인해주세요!")
                        signInPw.value = "";
                        signInPw2.value = "";
                        signInPw.focus();
                    }
                });

                // 전화번호 함수
                function autoHypenPhone(str) {
				    str = str.replace(/[^0-9]/g, '');
				    var tmp = '';
				    if (str.length < 4) {
				        return str;
				    } else if (str.length < 7) {
				        tmp += str.substr(0, 3);
				        tmp += '-';
				        tmp += str.substr(3);
				        return tmp;
				    } else if (str.length < 11) {
				        tmp += str.substr(0, 3);
				        tmp += '-';
				        tmp += str.substr(3, 3);
				        tmp += '-';
				        tmp += str.substr(6);
				        return tmp;
				    } else {
				        tmp += str.substr(0, 3);
				        tmp += '-';
				        tmp += str.substr(3, 4);
				        tmp += '-';
				        tmp += str.substr(7);
				        return tmp;
				    }
				    return str;
				}
				
				function formatPhoneNumber(event) {
				    var cellPhone = document.getElementById('cellPhone');
				    var _val = cellPhone.value.trim();
				    cellPhone.value = autoHypenPhone(_val);
				}

                // 주소검색api 회원 가입용
                function execDaumPostcode() {
                    new daum.Postcode({
                        oncomplete: function (data) {
                            // 팝업을 통한 검색 결과 항목 클릭 시 실행
                            var addr = ''; // 주소_결과값이 없을 경우 공백 
                            var extraAddr = ''; // 참고항목

                            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                            if (data.userSelectedType === 'R') { // 도로명 주소를 선택
                                addr = data.roadAddress;
                            } else { // 지번 주소를 선택
                                addr = data.jibunAddress;
                            }

                            if (data.userSelectedType === 'R') {
                                if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                                    extraAddr += data.bname;
                                }
                                if (data.buildingName !== '' && data.apartment === 'Y') {
                                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                                }
                                if (extraAddr !== '') {
                                    extraAddr = ' (' + extraAddr + ')';
                                }
                            } else {
                                document.getElementById("UserAdd1").value = '';
                            }

                            // 선택된 우편번호와 주소 정보를 input 박스에 넣는다.
                            document.getElementById('zipp_code_id').value = data.zonecode;
                            document.getElementById("UserAdd1").value = addr;
                            document.getElementById("UserAdd1").value += extraAddr;
                            document.getElementById("UserAdd2").focus(); // 우편번호 + 주소 입력이 완료되었음으로 상세주소로 포커스 이동
                        }
                    }).open();
                }
                
             // 주소검색api 회원 정보 수정
                function updateExecDaumPostcode() {
                    new daum.Postcode({
                        oncomplete: function (data) {
                            // 팝업을 통한 검색 결과 항목 클릭 시 실행
                            var addr = ''; // 주소_결과값이 없을 경우 공백 
                            var extraAddr = ''; // 참고항목

                            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                            if (data.userSelectedType === 'R') { // 도로명 주소를 선택
                                addr = data.roadAddress;
                            } else { // 지번 주소를 선택
                                addr = data.jibunAddress;
                            }

                            if (data.userSelectedType === 'R') {
                                if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                                    extraAddr += data.bname;
                                }
                                if (data.buildingName !== '' && data.apartment === 'Y') {
                                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                                }
                                if (extraAddr !== '') {
                                    extraAddr = ' (' + extraAddr + ')';
                                }
                            } else {
                                document.getElementById("updateUserAdd1").value = '';
                            }

                            // 선택된 우편번호와 주소 정보를 input 박스에 넣는다.
                            document.getElementById('update_zipp_code_id').value = data.zonecode;
                            document.getElementById("updateUserAdd1").value = addr;
                            document.getElementById("updateUserAdd1").value += extraAddr;
                            document.getElementById("updateUserAdd2").focus(); // 우편번호 + 주소 입력이 완료되었음으로 상세주소로 포커스 이동
                        }
                    }).open();
                }
            </script>
		</main>
		<footer></footer>
	</div>
</body>

</html>