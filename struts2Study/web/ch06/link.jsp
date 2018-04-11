<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-04-11
  Time: 오후 2:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h4>Ex one : JSP 직접 링크</h4>
<br>
<s:url var="gotoLinkPage" value="/ch06/gotoLink.jsp">
    <s:param name="param">이것은 파라미터 입니다</s:param>
</s:url>
<s:a href="%{gotoLinkPage}">gotoLink.jsp</s:a>
<br>
<br>
<br>
<h4>Ex two : Aciton 링크</h4>
<s:url var="gotoLinkAction" action="struts2/gotoLink">
    <s:param name="param">이것은 파라미터 입니다.</s:param>
</s:url>
<s:a href="%{gotoLinkAction}">gotoLink.action</s:a>


</body>
</html>
