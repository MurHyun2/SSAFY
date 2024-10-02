<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%
// 세션에 userRole을 임시로 설정
session.setAttribute("userRole", "user"); // "admin" 또는 "user", "guest" 등으로 변경 가능
%>
<!DOCTYPE html>

<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous" ></script>
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@700&display=swap" rel="stylesheet">
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
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
    max-width: calc(5 * 18rem + 40px); /* 카드 5개 + 여백 계산 (10px 여백 * 4개) */
    margin: 2rem auto; /* 위 아래 여백 추가, 가운데 정렬 */
    gap: 20px; /* 카드 간의 간격 조정 */
    padding: 2rem; /* 전체 패딩 추가 */
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

.card:hover {
    transform: scale(1.07); /* 호버 시 확대 효과 */
    box-shadow: 0px 12px 20px rgba(0, 0, 0, 0.2); /* 호버 시 그림자 증가 */
}

/* 반응형 카드 크기 조정 */
@media (max-width: 768px) {
    .card {
        width: calc(50% - 20px); /* 작은 화면에서 2개씩 배치 */
    }
}

@media (max-width: 480px) {
    .card {
        width: calc(100% - 20px); /* 더 작은 화면에서 1개씩 배치 */
    }
}

/* iframe 스타일 개선 */
iframe {
    border-radius: 20px;
    width: 100%; /* iframe을 카드의 너비에 맞게 조정 */
    aspect-ratio: 16 / 9; /* 비율 유지 */
    border: none; /* 기본 테두리 제거 */
}

/* 버튼 스타일 개선 */
.btn {
    margin-left: 5px;
    margin-right: 5px;
}

/* 모달 창 스타일 개선 */
#loginModal, #signInModal, #updateModal, #insertModal {
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
    transition: background-color 0.3s ease, transform 0.2s ease, box-shadow 0.3s ease; /* 애니메이션 효과 */
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
@media (max-width: 768px) {
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
</style>

</head>

<body>
	<div class="text-bg-dark p-3">
		<header>
		    <nav class="navbar navbar-expand-lg navbar-dark bg-dark border-bottom border-body py-3" data-bs-theme="dark">
		        <div class="container d-flex flex-column align-items-center">
		            <!-- SSAFIT Logo and Title -->
		            <a class="navbar-brand" href="#video-section" style="letter-spacing: 3px;">
		                SSAFIT
		            </a>
		            <!-- Centered Tagline -->
		            <p class="text-center text-white mt-2 mb-0">
		                <em>"Unlock Your Potential with Expert Fitness Video Reviews"</em>
		            </p>
		            <!-- Toggler for Mobile View -->
		            <button class="navbar-toggler mt-2" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
		                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
		                <span class="navbar-toggler-icon"></span>
		            </button>
		            <!-- Navigation Menu -->
		            <div class="collapse navbar-collapse justify-content-center mt-3" id="navbarNavDropdown">
		                <ul class="navbar-nav">
		                    <c:choose>
		                        <c:when test="${sessionScope.userRole == 'guest'}">
		                            <!-- Guest 로그인 및 회원가입 버튼 -->
		                            <li class="nav-item me-3">
		                                <button type="button" id="main-login-btn" class="btn btn-outline-light"
		                                    data-bs-toggle="modal" data-bs-target="#loginModal" data-bs-whatever="@mdo">
		                                    <i class="fas fa-sign-in-alt"></i> Login
		                                </button>
		                            </li>
		                            <li class="nav-item">
		                                <a class="btn btn-outline-light" href="#" id="signIn-a" data-bs-toggle="modal"
		                                    data-bs-target="#signInModal" data-bs-whatever="@mdo">
		                                    Sign Up
		                                </a>
		                            </li>
		                        </c:when>
		                        <c:otherwise>
		                            <!-- 로그인된 사용자 로그아웃 버튼 -->
		                            <li class="nav-item">
		                                <button type="button" id="main-logout-btn" class="btn btn-outline-light">
		                                    <i class="fas fa-sign-out-alt"></i> Logout
		                                </button>
		                            </li>
		                        </c:otherwise>
		                    </c:choose>
		                    <!-- 드롭다운 메뉴 -->
		                    <li class="nav-item dropdown ms-3">
		                        <a class="nav-link dropdown-toggle text-light" href="#" role="button" data-bs-toggle="dropdown"
		                            aria-expanded="false">
		                            Menu
		                        </a>
		                        <ul class="dropdown-menu">
		                            <li><a class="dropdown-item" href="#">마이페이지</a></li>
		                            <li><a class="dropdown-item" href="#">메뉴1</a></li>
		                            <li><a class="dropdown-item" href="#">메뉴2</a></li>
		                        </ul>
		                    </li>
		                </ul>
		            </div>
		        </div>
		    </nav>
		</header>
		<main style="width: 70%; margin: 0 auto;">
			<br>
			<introduce>
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
				<h2 class="text-center text-dark fw-bold" style="font-size: 2.5rem; letter-spacing: 1.5px;">Unlock Your Fitness Journey</h2>
   				<p class="text-center text-muted" style="font-size: 1.2rem;">Explore our handpicked selection of fitness videos</p>
				<c:if test="${sessionScope.userRole == 'admin'}">
					<div>
					    <button type="button" id="register-video-btn" class="btn btn-primary rounded-pill fw-bold" 
					        data-bs-toggle="modal" data-bs-target="#insertModal" data-bs-whatever="@mdo">
					        <i class="fas fa-plus-circle"></i> 동영상 등록
					    </button>
					</div>
				</c:if>
			</div>
			<!-- ----------------------------운동 카드 목록 START-------------------------------- -->
			<div id="video-section" class="card-box">
				<c:choose>
					<c:when test="${sessionScope.userRole == 'admin'}">
						<!-- admin일 때 전체 리스트 출력 -->
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
								<div class="card-body">
									<form style="display: inline;">
										<button class="btn btn-outline-dark" type="submit">리뷰</button>
										<button type="button"
											class="btn btn-outline-primary update-btn"
											data-bs-toggle="modal" data-bs-target="#updateModal"
											data-video-no="${video.videoNo}" data-url="${video.videoURL}"
											data-title="${video.videoTitle}"
											data-exercise-topic="${video.category}"
											data-exercise-area1="${video.part}"
											data-channel-name="${video.channelName}">수정</button>
									</form>

									<form action="${pageContext.request.contextPath }/board"
										method="post" style="display: inline;"
										onsubmit="return confirmDelete();">
										<input type="hidden" name="action" value="delete"> <input
											type="hidden" name="videoNo" value="${video.videoNo}">
										<button type="submit" class="btn btn-outline-danger">삭제</button>
									</form>
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<!-- admin이 아닐 때 무작위 리스트 출력 -->
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
									<form action="/review">
										<button class="btn btn-outline-primary work-out-btn"
											type="button" onclick="window.open('${video.videoURL}')">운동하기</button>
										<input type="hidden" name="action" value="review"> <input
											type="hidden" name="videoNo" value="${video.videoNo}">
										<button class="btn btn-outline-dark">리뷰</button>
									</form>
								</div>
							</div>
						</c:forEach>
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
							<h1 class="modal-title fs-5" id="exampleModalLabel">Login</h1>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<form method="post">
								<div class="mb-3">
									<label for="recipient-name" class="col-form-label">아이디:</label>
									<input type="text" class="form-control" id="loginId">
								</div>
								<div class="mb-3">
									<label for="message-text" class="col-form-label">패스워드:</label>
									<input type="password" class="form-control" id="loginPw">
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" id="closeBtn" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>
							<button type="button" class="btn btn-primary" id="loginBtn">Login</button>
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
							<form method="post">
								<div class="mb-3">
									<label for="recipient-name" class="col-form-label">■
										아이디:</label> <input type="text" class="form-control" id="signInId">
								</div>
								<div class="mb-3">
									<label for="message-text" class="col-form-label">■
										패스워드:</label> <input type="password" class="form-control"
										id="signInPw">
								</div>
								<div class="mb-3">
									<label for="message-text" class="col-form-label">■ 패스워드
										확인:</label> <input type="password" class="form-control" id="signInPw2">
								</div>
								<div class="mb-3">
									<label for="message-text" class="col-form-label">■
										전화번호:</label> <input type="text" class="form-control" id="cellPhone"
										placeholder="010-1234-1234" maxlength="12">
								</div>
								<div class="mb-3">
									<label for="zipp_btn" class="form-label">■ 주소</label><br /> <input
										type="text" class="form-control mb-2" id="zipp_code_id"
										name="zipp_code" maxlength="10" placeholder="우편번호"
										style="width: 50%; display: inline;"> <input
										type="button" id="zipp_btn" class="btn btn-primary"
										onclick="execDaumPostcode()" value="우편번호 찾기"><br>
									<input type="text" class="form-control mb-2" name="user_add1"
										id="UserAdd1" maxlength="40" placeholder="기본 주소를 입력하세요"
										required>
									<div class="invalid-feedback">주소를 입력해주시기 바랍니다!</div>
									<input type="text" class="form-control" name="user_add2"
										id="UserAdd2" maxlength="40" placeholder="상세 주소를 입력하세요">
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" id="signUpBtn">회원가입</button>
							<button type="reset" class="btn btn-outline-dark">초기화</button>
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
							<h1 class="modal-title fs-5" id="exampleModalLabel">글 수정</h1>
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
			<script>

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
                
             // 수정 함수
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

                // 로그인 함수
                btn.addEventListener('click', () => {
                    const loginId = document.getElementById('loginId').value;
                    const loginPw = document.getElementById('loginPw').value;

                    if (loginId == "test" && loginPw == "test" || loginId == "1" && loginPw == "1") {
                        alert("Login 성공!");

                        document.getElementById('loginId').value = "";
                        document.getElementById('loginPw').value = "";

                        mLoginBtn.style.display = 'none';
                        signInA.style.display = 'none';

                        mLogoutBtn.style.display = 'block';

                        document.getElementById('closeBtn').click();
                    } else {
                        alert("ID 혹은 Password를 확인해주세요!");
                    }  
                });

                // 로그아웃 함수
                mLogoutBtn.addEventListener('click', () => {
                    if (confirm("Logout 하시겠습니까?")) {
                        alert("Logout 성공!")

                        /* mLoginBtn.style.display = 'block';
                        signInA.style.display = 'block';

                        mLogoutBtn.style.display = 'none'; */
                    }
                });
                
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

                var cellPhone = document.getElementById('cellPhone');
                cellPhone.onkeyup = function (event) {
                    event = event || window.event;
                    var _val = this.value.trim();
                    this.value = autoHypenPhone(_val);
                }


                // 주소검색api
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
            </script>
		</main>
		<footer></footer>
	</div>
</body>

</html>