<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-04-12
  Time: 오후 3:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<b>당신이 가장 좋아하는 색깔은?</b>
<br>
<br>

<s:form action="/struts2/quiz">
    <s:textfield label="이름" name="name"/>
    <s:textfield label="나이" name="age"/>
    <s:textfield label="색깔" name="answer"/>
    <s:submit/>
</s:form>

</body>
</html>
