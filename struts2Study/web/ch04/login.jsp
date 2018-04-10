<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-04-10
  Time: 오후 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<meta name="viewport" content="width=device-width, initial-scale = 1.0"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>로그인페이지</h3>
로그인 아이디 : <s:property value="id"></s:property>
<br>
로그인한 사람이름 : <s:property value="name"></s:property>

<button onclick="window.location.href='RegFormAction.action'">뒤로가기</button>
</body>
</html>
