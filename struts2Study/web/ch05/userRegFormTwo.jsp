<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-04-11
  Time: 오전 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form method="post" action="struts2/UserRegAction">
    <br>
    <label for="id">아이디</label>
    <input type="text" name="userId" id="id" >
    <br>
    <label for="pass">비밀번호</label>
    <input type="password" name="userPass" id="pass" >
    <br>
    <label for="name">이름</label>
    <input type="text" name="userName" id="name" >
    <br>
    <input type="submit" value="전송">
</s:form>

</body>
</html>
