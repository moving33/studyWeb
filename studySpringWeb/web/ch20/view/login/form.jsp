<%--

  Created by IntelliJ IDEA.
  User: J
  Date: 2018-04-26
  Time: 오후 5:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<form:form modelAttribute="LoginCommad" action="">
    <form:errors element="div"/>
    아이디 : <form:input path="userId"/>
    <form:errors path="userId"/>
    <br>
    패스워드 : <form:password path="password" showPassword="false"/>
    <form:errors path="password"/>
    <br>
    <input type="submit">
</form:form>
</body>
</html>
