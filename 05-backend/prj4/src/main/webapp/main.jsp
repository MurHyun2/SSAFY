<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
    <style>
        .navbar bg-dark border-bottom border-body {
            display: flex;
        }

        body {}

        .card-box {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }

        .card {
            margin: 10px;
            border-radius: 20px;
        }

        iframe {
            border-radius: 20px;
            width: 17.9rem;
        }

        .btn {
            margin-left: 5px;
            margin-right: 5px;
        }

        #main-logout-btn {
            display: none;
        }

        #loginModal,
        #signInModal {
            color: black;
        }

        .navbar {
            border-radius: 10px;
        }
    </style>
</head>

<body>
    <div class="text-bg-dark p-3">
        <header>
            <nav class="navbar bg-dark border-bottom border-body" data-bs-theme="dark">
                <nav class="navbar bg-body-tertiary">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="#">
                            SSAFIT
                        </a>
                    </div>
                </nav>
                <nav class="navbar navbar-expand-lg bg-body-tertiary">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="#"></a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false"
                            aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNavDropdown">
                            <ul class="navbar-nav">
                                <button type="button" id="main-login-btn" class="btn btn-primary" data-bs-toggle="modal"
                                    data-bs-target="#loginModal" data-bs-whatever="@mdo">Login</button>
                                </button>
                                <!-- 로그아웃 버튼 -->
                                <button type="button" id="main-logout-btn" class="btn btn-primary">Logout</button>
                                <!-- 로그인 버튼 -->
                                <!-- 회원가입 버튼 -->
                                <li class="nav-item">
                                    <a class="nav-link" href="#" id="signIn-a" data-bs-toggle="modal"
                                        data-bs-target="#signInModal" data-bs-whatever="@mdo">Sign-in</a>
                                </li>
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
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
            </nav>
        </header>
        <main>
            <introduce>
                <div id="carouselExampleIndicators" class="carousel slide">
                    <div class="carousel-indicators">
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0"
                            class="active" aria-current="true" aria-label="Slide 1"></button>
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                            aria-label="Slide 2"></button>
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                            aria-label="Slide 3"></button>
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
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                        data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                        data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </introduce>
            <div>
                <br>
                <h2>추천 운동 영상</h2>
            </div>
            <!-- ----------------------------운동 카드 목록-------------------------------- -->
            <div class="card-box">
                <div class="card" style="width: 18rem;">
                    <iframe width="560" height="315" src="https://www.youtube.com/embed/50WCSpZtdmA?si=YYrQCe5tfK7FBNs9"
                        title="YouTube video player" frameborder="0"
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                        referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                    <div class="card-body">
                        <h5 class="card-title">운동 이름</h5>
                        <p class="card-text">운동 소개글</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">운동 주제: 요가</li>
                        <li class="list-group-item">운동 부위: 전신</li>
                        <li class="list-group-item">채널이름: 심으뜸</li>
                    </ul>
                    <div class="card-body">
                        <button class="btn btn-primary" type="submit">
                            운동하기
                        </button>
                        <button class="btn btn-primary" type="submit" onClick="location.href='review.html'">
                            리뷰
                        </button>
                    </div>
                </div>
                <!-- 운동 카드 하나 끝 -->
                <div class="card" style="width: 18rem;">
                    <!-- <img src="..." class="card-img-top" alt="..."> -->
                    <iframe width="560" height="315" src="https://www.youtube.com/embed/Kk7TQGqQ3nA?si=9naoHt8kGsxpLuHi"
                        title="YouTube video player" frameborder="0"
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                        referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                    </iframe>
                    <div class="card-body">
                        <h5 class="card-title">운동 이름</h5>
                        <p class="card-text">운동 소개글</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">운동 주제: 요가</li>
                        <li class="list-group-item">운동 부위: 전신</li>
                        <li class="list-group-item">채널이름: 빵느</li>
                    </ul>
                    <div class="card-body">
                        <button class="btn btn-primary" type="submit">
                            운동하기
                        </button>
                        <button class="btn btn-primary" type="submit" onClick="location.href='review.html'">
                            리뷰
                        </button>
                    </div>
                </div>
                <div class="card" style="width: 18rem;">
                    <!-- <img src="..." class="card-img-top" alt="..."> -->
                    <iframe width="560" height="315" src="https://www.youtube.com/embed/MTU4iCDntjs?si=XJSfkJrFHv8GjrLz"
                        title="YouTube video player" frameborder="0"
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                        referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                    <div class="card-body">
                        <h5 class="card-title">운동 이름</h5>
                        <p class="card-text">운동 소개글</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">운동 주제: 요가</li>
                        <li class="list-group-item">운동 부위: 전신</li>
                        <li class="list-group-item">채널이름: Allblanc TV</li>
                    </ul>
                    <div class="card-body">
                        <button class="btn btn-primary" type="submit">
                            운동하기
                        </button>
                        <button class="btn btn-primary" type="submit" onClick="location.href='review.html'">
                            리뷰
                        </button>
                    </div>
                </div>
                <div class="card" style="width: 18rem;">
                    <!-- <img src="..." class="card-img-top" alt="..."> -->
                    <iframe width="560" height="315" src="https://www.youtube.com/embed/D3yExRi7EME?si=BoWbkjhRG096F_Ip"
                        title="YouTube video player" frameborder="0"
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                        referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                    <div class="card-body">
                        <h5 class="card-title">운동 이름</h5>
                        <p class="card-text">운동 소개글</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">운동 주제: 요가</li>
                        <li class="list-group-item">운동 부위: 상체</li>
                        <li class="list-group-item">채널이름: Mindful Yoga with Eileen</li>
                    </ul>
                    <div class="card-body">
                        <button class="btn btn-primary" type="submit">
                            운동하기
                        </button>
                        <button class="btn btn-primary" type="submit" onClick="location.href='review.html'">
                            리뷰
                        </button>
                    </div>
                </div>
                <div class="card" style="width: 18rem;">
                    <!-- <img src="..." class="card-img-top" alt="..."> -->
                    <iframe width="560" height="315" src="https://www.youtube.com/embed/02K-k6daPb4?si=xKoo3YEocujZ6LcF"
                        title="YouTube video player" frameborder="0"
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                        referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                    <div class="card-body">
                        <h5 class="card-title">운동 이름</h5>
                        <p class="card-text">운동 소개글</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">운동 주제: 유산소</li>
                        <li class="list-group-item">운동 부위: 전신</li>
                        <li class="list-group-item">채널이름: 빅씨스 Bigsis</li>
                    </ul>
                    <div class="card-body">
                        <button class="btn btn-primary" type="submit">
                            운동하기
                        </button>
                        <button class="btn btn-primary" type="submit" onClick="location.href='review.html'">
                            리뷰
                        </button>
                    </div>
                </div>
                <div class="card" style="width: 18rem;">
                    <!-- <img src="..." class="card-img-top" alt="..."> -->
                    <iframe width="560" height="315" src="https://www.youtube.com/embed/gMaB-fG4u4g?si=tPZehYaEmT-rwMA7"
                        title="YouTube video player" frameborder="0"
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                        referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                    <div class="card-body">
                        <h5 class="card-title">운동 이름</h5>
                        <p class="card-text">운동 소개글</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">운동 주제: 유산소</li>
                        <li class="list-group-item">운동 부위: 전신</li>
                        <li class="list-group-item">채널이름: ThankyouBUBU</li>
                    </ul>
                    <div class="card-body">
                        <button class="btn btn-primary" type="submit">
                            운동하기
                        </button>
                        <button class="btn btn-primary" type="submit" onClick="location.href='review.html'">
                            리뷰
                        </button>
                    </div>
                </div>
                <div class="card" style="width: 18rem;">
                    <!-- <img src="..." class="card-img-top" alt="..."> -->
                    <iframe width="560" height="315" src="https://www.youtube.com/embed/swRNeYw1JkY?si=Fl2gaE1QjrnJLsgf"
                        title="YouTube video player" frameborder="0"
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                        referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                    <div class="card-body">
                        <h5 class="card-title">운동 이름</h5>
                        <p class="card-text">운동 소개글</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">운동 주제: 유산소</li>
                        <li class="list-group-item">운동 부위: 전신</li>
                        <li class="list-group-item">채널이름: ThankyouBUBU</li>
                    </ul>
                    <div class="card-body">
                        <button class="btn btn-primary" type="submit">
                            운동하기
                        </button>
                        <button class="btn btn-primary" type="submit" onClick="location.href='review.html'">
                            리뷰
                        </button>
                    </div>
                </div>

            </div>
            <!-- 로그인 모달창 -->
            <div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel">Login</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
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
                            <!-- <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                data-bs-target="#signInModal" data-bs-whatever="@mdo">회원가입</button> -->
                            <button type="button" id="closeBtn" class="btn btn-secondary"
                                data-bs-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="loginBtn">Login</button>
                        </div>
                    </div>
                </div>
            </div>

            <!-- 회원가입 모달창 -->
            <div class="modal fade" id="signInModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel">회원가입</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form method="post">
                                <div class="mb-3">
                                    <label for="recipient-name" class="col-form-label">■ 아이디:</label>
                                    <input type="text" class="form-control" id="signInId">
                                </div>
                                <div class="mb-3">
                                    <label for="message-text" class="col-form-label">■ 패스워드:</label>
                                    <input type="password" class="form-control" id="signInPw">
                                </div>
                                <div class="mb-3">
                                    <label for="message-text" class="col-form-label">■ 패스워드 확인:</label>
                                    <input type="password" class="form-control" id="signInPw2">
                                </div>
                                <div class="mb-3">
                                    <label for="message-text" class="col-form-label">■ 전화번호:</label>
                                    <input type="text" class="form-control" id="cellPhone" placeholder="010-1234-1234"
                                        maxlength="14">
                                </div>
                                <div class="mb-3">
                                    <label for="zipp_btn" class="form-label">■ 주소</label><br />
                                    <input type="text" class="form-control mb-2" id="zipp_code_id" name="zipp_code"
                                        maxlength="10" placeholder="우편번호" style="width: 50%; display: inline;">
                                    <input type="button" id="zipp_btn" class="btn btn-primary"
                                        onclick="execDaumPostcode()" value="우편번호 찾기"><br>
                                    <input type="text" class="form-control mb-2" name="user_add1" id="UserAdd1"
                                        maxlength="40" placeholder="기본 주소를 입력하세요" required>
                                    <div class="invalid-feedback">주소를 입력해주시기 바랍니다!</div>
                                    <input type="text" class="form-control" name="user_add2" id="UserAdd2"
                                        maxlength="40" placeholder="상세 주소를 입력하세요">
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" id="sigInBtn">회원가입</button>
                        </div>
                    </div>
                </div>
            </div>
            <script>
                // let data = JSON.parse(JSON.stringify(Params));
                // console.log(data[0].id);

                // for (let index = 0; index < data.length; index++) {
                //     li.setAttribute('id', data[index].id);
                //     const textNode = document.createTextNode(data[index].title);
                //     li.appendChild(textNode);
                //     document.getElementById("val").appendChild(li);
                // }

                // btn-close 함수
                const closeBtn = document.querySelector('.btn-close');
                closeBtn.addEventListener('click', () => {
                    document.getElementById('loginId').value = "";
                    document.getElementById('loginPw').value = "";
                })

                // 로그인 함수
                const btn = document.getElementById('loginBtn');
                const mLoginBtn = document.getElementById('main-login-btn');
                const mLogoutBtn = document.getElementById('main-logout-btn');
                const signInA = document.getElementById('signIn-a');


                btn.addEventListener('click', () => {
                    const loginId = document.getElementById('loginId').value;
                    const loginPw = document.getElementById('loginPw').value;

                    if (loginId != "test" || loginPw != "test") {
                        alert("ID 혹은 Password를 확인해주세요!");

                    } else if (loginId == "test" && loginPw == "test") {
                        alert("Login 성공!");

                        document.getElementById('loginId').value = "";
                        document.getElementById('loginPw').value = "";

                        mLoginBtn.style.display = 'none';
                        signInA.style.display = 'none';

                        mLogoutBtn.style.display = 'block';

                        document.getElementById('closeBtn').click();
                    }
                });

                // 로그아웃 함수
                mLogoutBtn.addEventListener('click', () => {
                    if (confirm("Logout 하시겠습니까?")) {
                        alert("Logout 성공!")

                        mLoginBtn.style.display = 'block';
                        signInA.style.display = 'block';

                        mLogoutBtn.style.display = 'none';


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
        <footer>
        </footer>
    </div>
</body>

</html>