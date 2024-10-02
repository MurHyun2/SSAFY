<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%
// 세션에 userRole을 임시로 설정
session.setAttribute("userRole", "user"); // 또는 "user", "guest" 등으로 변경 가능
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
	crossorigin="anonymous"></script>
<style>
.navbar bg-dark border-bottom border-body {
	display: flex;
}

body {
	
}

.card-box {
	display: flex;
	flex-wrap: wrap; /* 카드가 줄바꿈 할 수 있도록 설정 */
	justify-content: center; /* 가운데 정렬 */
	max-width: calc(5 * 18rem + 40px); /* 카드 5개 + 여백 계산 (10px 여백 * 4개) */
	margin: 0 auto; /* 가운데 정렬 */
}

.card {
	margin: 10px; /* 카드 간의 간격 */
	border-radius: 20px;
	width: 18rem; /* 카드의 고정 너비 설정 */
	box-sizing: border-box; /* 패딩 및 마진을 포함하여 너비 계산 */
}

/* 작은 화면에서 반응형을 위해 카드 크기 조정 */
@media ( max-width : 768px) {
	.card {
		width: calc(50% - 20px); /* 작은 화면에서 2개씩 배치 */
	}
}

iframe {
	border-radius: 20px;
	width: 100%; /* iframe을 카드의 너비에 맞게 조정 */
}

.btn {
	margin-left: 5px;
	margin-right: 5px;
}

#loginModal, #signInModal, #updateModal {
	color: black;
}

.navbar {
	border-radius: 10px;
}

.carousel-item img {
	height: 600px; /* 최대 높이를 600px로 설정 */
	width: 90%; /* 너비를 부모 요소에 맞추어 100%로 설정 */
	object-fit: cover; /* 이미지 비율을 유지하며 영역을 채움 */
}

.content-header {
	display: flex;
	justify-content: space-between;
	align-items: center;
}
</style>

</head>

<body>
	<div class="text-bg-dark p-3">
		<header>
			<nav class="navbar bg-dark border-bottom border-body"
				data-bs-theme="dark">
				<nav class="navbar bg-body-tertiary">
					<div class="container-fluid">
						<a class="navbar-brand" href="#"> SSAFIT </a>
					</div>
				</nav>
				<nav class="navbar navbar-expand-lg bg-body-tertiary">
					<div class="container-fluid">
						<button class="navbar-toggler" type="button"
							data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
							aria-controls="navbarNavDropdown" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse" id="navbarNavDropdown">
							<ul class="navbar-nav">
								<c:choose>
									<c:when test="${sessionScope.userRole == 'guest'}">
										<!-- Guest 사용자일 때 로그인 및 회원가입 버튼 -->
										<button type="button" id="main-login-btn"
											class="btn btn-primary" data-bs-toggle="modal"
											data-bs-target="#loginModal" data-bs-whatever="@mdo">Login</button>
										<li class="nav-item"><a class="nav-link" href="#"
											id="signIn-a" data-bs-toggle="modal"
											data-bs-target="#signInModal" data-bs-whatever="@mdo">Sign-in</a></li>
									</c:when>
									<c:otherwise>
										<!-- 다른 사용자일 때 로그아웃 버튼 -->
										<button type="button" id="main-logout-btn"
											class="btn btn-primary">Logout</button>
									</c:otherwise>
								</c:choose>
								<!-- 드롭다운 메뉴 -->
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" role="button"
									data-bs-toggle="dropdown" aria-expanded="false"> Menu </a>
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
			</nav>
		</header>
		<main style="width: 65%; margin: 0 auto;">
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
				<h2>추천 운동 영상</h2>
				<c:if test="${sessionScope.userRole == 'admin'}">
					<div>
						<button type="button" class="btn btn-light">글쓰기</button>
					</div>
				</c:if>
			</div>
			<!-- ----------------------------운동 카드 목록 START-------------------------------- -->
			<div class="card-box">
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
								        <button type="button" class="btn btn-outline-primary update-btn"
								                data-bs-toggle="modal" data-bs-target="#updateModal"
								                data-video-no="${video.videoNo}" data-url="${video.videoURL}"
								                data-title="${video.videoTitle}"
								                data-exercise-topic="${video.category}"
								                data-exercise-area1="${video.part}"
								                data-channel-name="${video.channelName}">수정</button>
								    </form>
								    
								    <form action="/board" method="post" style="display: inline;" onsubmit="return confirmDelete();">
								        <input type="hidden" name="action" value="deleteBoard">
								        <input type="hidden" name="videoNo" value="${video.videoNo}">
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
										<button class="btn btn-outline-primary work-out-btn" type="button"
											onclick="window.open('${video.videoURL}')">운동하기</button>
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
							<button type="button" class="btn btn-primary" id="sigInBtn">회원가입</button>
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
							<form method="post" action="/board">
								<input type="hidden" name="action" value="update" />
								<input type="hidden" id="updateVideoNo" name="videoNo" />
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
									<button type="submit" class="btn btn-primary" id="sigInBtn">수정</button>
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
                const sigInBtn = document.getElementById('sigInBtn');

                sigInBtn.addEventListener('click', () => {
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
		<footer> </footer>
	</div>
</body>

</html>