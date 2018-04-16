<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-04-11
  Time: 오후 1:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <s:form action="/struts2/echo" theme="simple">
        입 력 : <s:textfield name="echo"/>
        <br>
        <br>
        전송된 값 : <s:property value="echo"/>
        <br><br>
        <s:submit value="전송"></s:submit>
    </s:form>

</body>
</html>
