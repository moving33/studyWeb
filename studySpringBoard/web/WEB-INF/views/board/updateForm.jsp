<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-05-07
  Time: 오후 6:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<html>
<head>
    <title>UpdateForm</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styleWrite.css"/>
</head>

<body>

<c:if test="${value eq 'pass'}">
    <script>
        alert("패스워드가 맞지 않습니다.");
    </script>
</c:if>
<div class="container">
    <div class="alert alert-success text-center">
        <strong>Modify Article</strong>
    </div>

    <div class="row">
        <form class="contact-form"
              method="post" name="boardVO" action="modifyForm.do"
              style="width: 60%; margin-left: 3%;">
<%--
            <form:hidden path="num" />
            <form:hidden path="readcount" />
            <form:hidden path="article_type"/>
            <form:hidden path="regdate" />--%>`

            <input hidden name="num" value="${vo.num}"/>
            <input hidden name="readcount" value="${vo.readcount}"/>
            <input hidden nane="article_type"/>
            <input hidden name="regdate"/>

            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="writer">작성자</label>글
                        <input type="text" class="form-control"
                               name="writer" id="writer" value="${vo.writer}" disabled="true"/>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="email">이메일</label>
                        <input type="email" class="form-control" id="email" value="${vo.email}" nam="email"
                               disabled="true"/>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <label for="subject">제목</label>
                        <input type="text" class="form-control" id="subject" name="subject" required/>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <label for="content">내용</label>
                        <input type="text" id="content" name="content" class="form-control textarea" rows="10" required style="text-align: left"/>
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="pass">비밀번호</label>
                        <input type="password" class="form-control" name="pass" autocomplete="off" id="pass"
                               placeholder="password" required/>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn main-btn pull-right">수정하기</button>
                    <button type="button" class="btn pull-right" onclick="window.location='list.do'">돌아가기</button>
                </div>
            </div>
        </form>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
        integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
        integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
        crossorigin="anonymous"></script>
</body>
</html>
