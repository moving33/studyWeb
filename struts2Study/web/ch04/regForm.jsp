<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-04-10
  Time: 오후 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="width=device-width, initial-scale = 1.0"/>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>회원 가입 정보 입력</h3>
<form method="post" name="regForm" action="RegAction.action">
    <label for="id">아이디</label>&nbsp;&nbsp;&nbsp;
    <input type="text" id="id" name="id" value="${id}"/>
    <br>
    <label for="pass">패스워드</label>
    <input type="password" id="pass" name="pass" value="${pass}"/>
    <br>
    <label for="name">이름</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="text" id="name" name="name" value="${name}"/>
    <br>
    <input type="submit" value="회원가입"/>
    <input type="reset"  value="다시입력"/>
</form>
</body>
</html>
