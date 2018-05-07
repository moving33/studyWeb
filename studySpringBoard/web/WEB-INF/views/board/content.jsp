<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-05-04
  Time: 오전 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ViewArticle</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/viewArticle.css"/>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">


    <script>


        //날짜 포맷
        function getFormatDate(date) {

            var year = date.getFullYear();                                 //yyyy

            var month = (1 + date.getMonth());                     //M

            month = month >= 10 ? month : '0' + month;     // month 두자리로 저장

            var day = date.getDate();                                        //d

            day = day >= 10 ? day : '0' + day;                            //day 두자리로 저장

            var hour = date.getHours();
            hour = hour >= 10 ? hour : '0' + hour;

            var min = date.getMinutes();
            min = min >= 10 ? min : '0' + min;

            var secound = date.getSeconds();
            secound = secound >= 10 ? secound : '0' + secound;

            return year + '.' + month + '.' + day + ' ' + hour + ':' + min + ':' + secound;

        }

        //댓글보여주기
        function showHtml(data, commentPageNum) {
            var html = "<table class='table table-striped table-bordered' style='margin-top: 10px;'><tbody>";

            var values = []; // arraylist로 받겟다 선언

            values = data.list;
            //리플개수 추가
            //var plusReply = 0;

            //var total = $('ul li').length;


            $.each(values, function (index, value) {

                alert(value.comment_writer);

                html += "<tr align='center'>";
                html += "<td style='width: 10%;'>" + (index + 1) + "</td>";
                html += "<td style='width: 20%;'>" + value.comment_writer + "</td>";
                html += "<td style='width: 50%;' align='left'>" + value.comment + "</td>";

                //json형식 변환

                var localedate = new Date(value.regdate_comment);
                var formatdate = getFormatDate(localedate);

                var n = String(value.comment_num);
                var p = value.comment_pass;

                alert(n + "???" + p);
                alert(formatdate);

                html += "<td>" + formatdate + "</td>";
                html += "<td><button class='btn' onclick='deleteComment(" + n + "," + p + ")'>삭제</button></td>";
                html += "</tr>";

            });
            html += "</tbody></table>";
            //정수변경

            commentPageNum = parseInt(commentPageNum);

            //commentCount는 동기화되어 값을 받아오기 때문에, 댓글 insert에 즉각적으로 처리되지 못한다.
            if ("${count}" > commentPageNum * 10) {
                nextPageNum = commentPageNum + 1;
                html += "<input type='button' class='btn btn-default' onclick='getComment(nextPageNum, event)' value='다음 comment 보기'>";
            }

            $("#showComment").html(html);
            $("#commentContent").val("");
            $("#commentContent").focus();
            $('#showComment').show();
            //$("#commentRead").val(textReply);
        }

        //가져오기
        function getComment(commPageNum, event) {
            var url = "/board/comment/" + $("#currArticleNum").val() + ".do";
            //var commentPageNum = JSON.stringify(commPageNum);
            alert(url);
            $.ajax({
                url: url,
                type: "POST",
                dataType: "json",
                contentType: "application/json; charset=utf-8",
                data: commPageNum,

                error: function () {
                    alert("댓글이 없습니다!");
                    $('#showComment').hide();
                },
                success: function (data) {
                    if (data == null) {
                        alert("해당 게시글의 댓글이 존재하지 않습니다.");
                        return;
                    } else {
                        /* var values = []; // arraylist로 받겟다 선언
                         values = data.list;
                         $.each(values,function (index,value) {
                             alert(value.comment_writer);
                         });*/
                    }

                    showHtml(data, commPageNum);
                    var position = $("#showComment table tr:last").position();
                    $('html, body').animate({scrollTop: position.top}, 400);        // 두 번째 param은 스크롤 이동하는 시간
                }
            })
        }

        //댓글 쓰기
        function writeComment() {
            alert("aaaaa");

            var writer = $("#commentWriter").val();
            var pass = $("#commentPass").val();
            var comment = $("#commentContent").val();

            if (writer == null || writer == '' || pass == null || pass == '' || comment == null || comment == '') {
                alert("양식에 맞게 댓글을 입력해주세요");
                return;
            }

            var form = {
                'comment_writer': writer,
                'comment_pass': pass,
                'comment': comment,
                'comment_num': null,
                'regdate_comment': null
            }

            var url = "/board/comment/" + $("#currArticleNum").val() + "/insert.do";

            alert(url);
            alert(writer + pass + comment);

            $.ajax({
                url: url,
                type: "POST",
                dataType: "json",
                contentType: "application/json; charset=utf-8",

                data: JSON.stringify(form)
                ,
                success: function (data) {
                    alert("comment 입력완료 " + data.result);
                    $("#commentContent").val("");
                    getComment(1, event);
                }

            });
        }

        //수정창이동
        function modifyArticle(articleNum) {
            window.location.href = "http://localhost:8080/board/modifyForm.do?num=" + articleNum;
        }

        //글삭제하기
        function deleteArticle(articleNum) {

            alert(articleNum);
            //값 입력받기
            var passwd = prompt('비밀번호를 입력해주세요');
            var passwdData = {
                'passwd': passwd,
                'articleNum': articleNum
            }
            var url = "/board/delete.do";
            alert(url);

            $.ajax({
                url: url,
                type: "POST",
                dataType: "json",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(passwdData),
                success: function (data) {

                    alert("aaaaaaaaa");

                    if (data.result == 0) {
                        alert("비밀번호가 틀렸습니다.");
                        return;
                    }

                    var result = confirm('정말로 삭제 하시겠습니까??');

                    if (result) {
                        window.location.href = "http://localhost:8080/board/deleteForm.do?num=" + articleNum;
                    } else {
                        return;
                    }
                }
            });


        }

        //댓글삭제하기
        function deleteComment(a, b) {

            var userPass = prompt('비밀번호를 입력해주세요');
            if (userPass != b) {
                alert("틀린 비밀번호입니다.");
                return;
            }
            var result = confirm('정말 삭제하시겠습니까?');
            var data = {
                'commentNum':a,
                'passwd':b
            };
            if (result) {
                $.ajax({
                    url:"/comment/delete.do",
                    method: "POST",
                    dataType: "json",
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(data),
                    success:function (data) {
                        alert("aaaaaaaaa");
                        if(data.result == "success"){
                            alert('삭제성공');
                            getComment(1,event);
                        }
                    }
                });
            } else {
                return;
            }

            alert(a + "//" + b);
        }
    </script>
</head>
<body>
<div class="container">
    <div class="alert alert-success text-center">
        <strong>View Article</strong>
    </div>
    <div class="row">
        <form method="post" name="writeForm" style="margin: auto">
            <input type="hidden" name="num" value="${vo.num}"/>
            <div class="col-md-12">
                <table class="table table-striped">
                    <tr>
                        <td><b>번호</b></td>
                        <td style="width: 15%;">${vo.num}</td>
                        <td><b>작성자</b></td>
                        <td style="width: 25%;">${vo.writer}</td>
                        <td><b>작성일</b></td>
                        <td style="width: 35%;">${vo.regdate}</td>
                    </tr>
                </table>
            </div>

            <div class="col-md-12">
                <table class="table table-hover">
                    <tr>
                        <td style="width:10%;"><b>제목</b></td>
                        <td style="width:70%; text-align: left">&nbsp;&nbsp;${vo.subject}</td>
                    </tr>
                </table>

                <table class="table table-hover">
                    <tr>
                        <td style="width: 90%; text-align: left;height: 350px">
                            ${vo.content}
                        </td>
                    </tr>
                    <tr>
                    </tr>
                </table>
                <button class="btn btn-outline-primary" onclick="modifyArticle(${vo.num}); return false;">수정</button>
                <button class="btn btn-outline-primary" onclick="deleteArticle(${vo.num}); return false;">삭제</button>
                <button class="btn btn-outline-primary" onclick="javascript:window.location='list.do'; return false;">
                    목록보기
                </button>
            </div>
        </form>
    </div>


    <%--댓글처리--%>
    <div class="input-group" role="group" aria-label="..."
         style="margin-top:2%;margin-left: 10%;width: 80%;flex-wrap: unset;">
        <div class="row" style="width: 75%;">
            <div class="col-auto" style="margin: auto;">
                <b>작성자</b>
                <input id="commentWriter" name="commentWriter" type="text" class="form-control" placeholder="ID"/>
                <b>비밀번호</b>
                <input id="commentPass" name="commentPass" type="password" class="form-control" placeholder="Pass"/>
            </div>

        </div>
        <textarea class="form-control" rows="3" id="commentContent" placeholder="댓글을 입력하세요."
                  style="width: 100%;"></textarea>
        <div class="btn-group btn-group-sm" role="group" aria-label="...">
            <input type="button" class="btn btn-outline-primary" value="댓글 쓰기" id="commentWritebtn"
                   style="margin-right: 2px;" onclick="writeComment()">
            <input type="button" class="btn btn-outline-primary" value="댓글 읽기(${commentCount})"
                   onclick="getComment(1, event)" id="commentRead">

            <input type="hidden" id="currArticleNum" value="${vo.num}"/>
        </div>
    </div>

    <!-- Comment 태그 추가 -->
    <div class="input-group" role="group" aria-label="..." style="margin-top: 10px; width: 100%;">
        <div id="showComment" style="text-align: center; margin: auto;"></div>
    </div>


</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
        integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
        integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
        crossorigin="anonymous"></script>
<script
        src="https://code.jquery.com/jquery-3.3.1.js"
        integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
        crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/resources/js/sugar.js"/>


</body>
</html>
