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

    <link rel="stylesheet" href="viewArticle.css" />
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">


    <%--ajax Set-up--%>
    <script>


        //댓글보여주기
        function showHtml(data,commentPageNum) {
            var html = "<table class='table table-striped table-bordered' style='margin-top: 10px;'><tbody>";
            $.each(data,function (index,data) {
                html += "<tr align='center'>";
                html += "<td>" + (index+1) + "</td>";
                html += "<td>" + data.list.comment_writer + "</td>";
                html += "<td align='left'>" + item.comment + "</td>";
                var presentDay = data.list.regdate_comment.substring(0, 14);
                html += "<td>" + presentDay + "</td>";
                html += "</tr>";
            });
            html+= "</tbody></table>";
            //정수변경
            commentPageNum = parsInt(commentPageNum);

            //commentCount는 동기화되어 값을 받아오기 때문에, 댓글 insert에 즉각적으로 처리되지 못한다.
            if("${count}" > commentPageNum * 10) {
                nextPageNum = commentPageNum + 1;
                html +="<input type='button' class='btn btn-default' onclick='getComment(nextPageNum, event)' value='다음 comment 보기'>";
            }

            $("#showComment").html(html);
            $("#commentContent").val("");
            $("#commentContent").focus();
        }

        function getComment(commPageNum, event) {
            var url = "/board/comment/"+$("#currArticleNum").val();
            var commentPageNum = JSON.stringify(commPageNum);
            alert(url);
            $.ajax({
                url: url,
                type:"POST",
                dataType:"json",
                contentType:"application/json; charset=utf-8",
                data:commentPageNum,

                error:function () {
                    alert("에러!");
                },
                success:function(data) {
                    if(data == null){
                        alert("해당 게시글의 댓글이 존재하지 않습니다.");
                        return;
                    }else{
                        alert(data[2].count);
                    }
                    console.log("comment를 정상적으로 조회하였습니다.");
                    console.log(JSON.stringify(data.list));
                    showHtml(data, commPageNum);
                    var position = $("#showComment table tr:last").position();
                    $('html, body').animate({scrollTop : position.top}, 400);        // 두 번째 param은 스크롤 이동하는 시간
                }
            })
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
                <button class="btn btn-outline-primary">수정</button>
                <button class="btn btn-outline-primary">삭제</button>
                <button class="btn btn-outline-primary">목록보기</button>
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
                   style="margin-right: 2px;">
            <input type="button" class="btn btn-outline-primary" value="댓글 읽기()"
                   onclick="getComment(1, event)" id="commentRead">

            <input type="hidden" id="currArticleNum" value="${vo.num}"/>
        </div>
    </div>

    <!-- Comment 태그 추가 -->
    <div class="input-group" role="group" aria-label="..." style="margin-top: 10px; width: 100%;">
        <div id="showComment" style="text-align: center;"></div>
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
</body>
</html>
