<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>운동영상 리뷰</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
    <script src="https://fontawesome.com/icons/dumbbell?f=classic&s=light"></script>
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

        table,
        th,
        td {
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
</head>

<body>
    <header>
        <div class="title">
            🦄운동영상 리뷰🦄
        </div>
        <hr>
    </header>

    <main>
        <div class="video">
            <iframe width="560" height="315" src="https://www.youtube.com/embed/50WCSpZtdmA?si=6NS965XyETmZ0vKu"
                title="YouTube video player" frameborder="0"
                allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
        </div>

        <hr>
        <div class="mainTop">
            <button id="reviewBtn">글작성</button>
            <input class="search" type="text" placeholder="제목, 내용으로 검색">
        </div>

        <div class="mainTop">
            <!-- <button id="modifyBtn">글수정</button> -->
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                글수정
              </button>
        </div>
        <hr>

        <table>
            <thead>
                <th>번호</th>
                <th class="th-2">제목</th>
                <th>작성자</th>
                <th>조회수</th>
                <th>작성시간</th>
            </thead>
            <tr>
                <td>4</td>
                <td class="tableTitle">와~</td>
                <td>a</td>
                <td>0</td>
                <td>2024-08-30</td>
            </tr>
            <tbody>

            </tbody>


        </table>
        <div id="modal" class="dialog">
            <div class="tb">
                <div class="inner" style="max-width:800px;"">
                <div class=" top">
                    <div class="title">🦄운동영상 리뷰🦄</div>
                    <!-- <a href="#" class="p_close">닫기</a> -->
                </div>
                <div class="ct">
                    <input type="text" id="reviewTitle" placeholder="제목">
                    <input type="text" placeholder="내용">
                    <button id="reg">등록</button>
                    <button id="can">취소</button>
                </div>
            </div>
        </div>
        </div>

        <p></p>

        </table>

        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">🦄운동영상 리뷰🦄</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <input type="text" id="editTitle" value="와~ 효과만점 운동 영상입니다!">
                        <input type="text" id="editContent" value="강추!! 강추!!!!">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
                        <button type="button" class="btn btn-primary">수정</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- <div id="modal2" class="dialog2">
            <div class="tb">
                <div class="inner" style="max-width:800px;"">
                <div class=" top">
                    <div class="title">🦄운동영상 리뷰🦄</div>
                    <a href="#" class="p_close">닫기</a>
                </div>
                <div class="ct">
                    <input type="text" id="editTitle" value="와~ 효과만점 운동 영상입니다!">
                    <input type="text" id="editContent" value="강추!! 강추!!!!">
                    <button id="mod">수정</button>
                    <button id="can">취소</button>
                </div>
            </div>
        </div> -->
        </div>

    </main>

    <footer>

    </footer>


    <script>
        const modal = document.querySelector("#modal");
        const btn1 = document.querySelector("#reviewBtn");
        // const close = document.querySelector(".p_close");

        const modal2 = document.querySelector("#modal2")
        const modifyBtn = document.querySelector("#modifyBtn");


        // 모달창 열기
        btn1.onclick = function () {
            modal.style.display = "block";
        }
        modifyBtn.onclick = function () {
            modal2.style.display = "block";
        }

        // 모달창 닫기
        close.onclick = function () {
            modal.style.display = "none";
        }

        // const reviewInput = document.querySelector("#reviewTitle")
        const reviewButton = document.querySelector("#reg")

        reviewButton.addEventListener('click', function (event) {
            const reviewTitle = document.querySelector("#reviewTitle").value;
            const pTag = document.querySelector('.tableTitle')
            pTag.innerText = reviewTitle;

            // if (reviewTitle.trim() !== "") {
            //     contst
            // }
        })



    </script>
</body>

</html>