<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-05-03
  Time: 오후 6:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta charset="UTF-8">
<html>
<head>
    <title>WriteForm</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="styleWrite.css"/>
</head>

<body>


<div class="container">
    <div class="alert alert-success text-center">
        <strong>당신의 생각을 적어주세요 !</strong>
    </div>

    <div class="row">
        <form:form role="form" id="contact-form" class="contact-form"
                   method="post" name="writeForm" action="writeForm.do"
                   commandName="boardVO"
                   style="width: 60%; margin-left: 3%;">

            <form:hidden path="num" />
            <form:hidden path="readcount" />
            <form:hidden path="article_type"/>
            <form:hidden path="regdate" />

            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <form:label  path="writer">작성자</form:label>글
                        <form:input type="text" class="form-control" placeholder="Writer" path="writer" />
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <form:label path="email">이메일</form:label>
                        <form:input type="email" class="form-control" placeholder="E-mail" path="email" />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <form:label path="subject">제목</form:label>
                        <form:input type="text" class="form-control"  placeholder="subject" path="subject"/>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <form:label path="content">내용</form:label>
                        <form:textarea path="content" class="form-control textarea" rows="10" placeholder="Message" />
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <form:label path="pass">비밀번호</form:label>
                        <form:input type="password" class="form-control" name="pass" autocomplete="off" id="pass" placeholder="password" path="pass"/>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn main-btn pull-right">SEND</button>
                    <button type="button" class="btn pull-right" onclick="window.location='list.do'">목록보기</button>
                </div>
            </div>
        </form:form>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
</body>
</html>
