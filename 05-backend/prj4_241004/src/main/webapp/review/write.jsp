<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
<style >
   .title {
            display: flex;
            justify-content: center;
            margin-top: 10px;
            font-size: 30px;
        }

        /***** 리뷰등록 모달 css *******/
      /*  .dialog {
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
        .writer {
            display: flex;
            width: 100%;
            height: 5%;
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
 */
</style>
	
</head>
<body>

   <div id="modal" class="dialog">
            <div class="tb">
                <div class="inner" style="max-width:800px;"">
                <div class=" top">
                    <div class="title">🦄운동영상 리뷰🦄</div>
                    <!-- <a href="#" class="p_close">닫기</a> -->
                </div>
                <div class="ct">
                <!-- 비디오번호에 해당하는 리뷰 이동하고 리뷰 작성하기. .  -->
                <form action="${pageContext.request.contextPath}/review?action=write&videoNo=${videoNo}" method="post">
                    <input type="text" placeholder="내용" name="content" required>
                    <input class = "writer" type="text" placeholder="작성자"  name="writer"  value = "${nickName}" required>
                    <button type="submit" id="reg">등록</button>
                    <!-- 취소 버튼 누르면 뒤로 돌아가기.  -->
                       <button type="button" id="can" onclick="history.back();">취소</button> 
                </form>
                </div>
            </div>
        </div>
        </div>




</body>
</html>
