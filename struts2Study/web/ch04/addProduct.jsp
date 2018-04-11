<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-04-10
  Time: 오후 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<meta name="viewport" content="width=device-width, initial-scale = 1.0"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form action="addProduct">
    제 품 등 록
    <br>
    <br>
    <s:textfield label="%{getText('label.product.name')}" name="name"></s:textfield>
    <s:textfield label="%{getText('label.product.model_no')}" name="modelNo"></s:textfield>
    <s:submit value="등 록"/>
</s:form>
</body>
</html>
