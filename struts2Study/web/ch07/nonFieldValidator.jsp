
<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-04-12
  Time: 오후 4:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<s:actionerror/>
<s:form action="/struts2/nonFieldValidator">
    <s:textfield name="test1" label="text1"/>
    <s:textfield name="test2" label="text2"/>
    <s:textfield name="test3" label="text3"/>
    <s:submit/>
</s:form>
</body>
</html>
