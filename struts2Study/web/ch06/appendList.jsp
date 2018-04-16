<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-04-12
  Time: 오전 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>append List</title>
</head>
<body>

    <s:append var="artist">
        <s:param value="%{listPainter}"></s:param>
        <s:param value="%{listMusician}"/>
    </s:append>

    <s:label>아티스트 ...</s:label>
    <ul>
        <s:iterator value="%{artist}">
            <li><s:property/></li>
        </s:iterator>
    </ul>
</body>
</html>
