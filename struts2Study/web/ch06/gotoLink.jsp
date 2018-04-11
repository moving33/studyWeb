<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-04-11
  Time: 오후 2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page pageEncoding="UTF-8" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

파라미터 : <s:property value="param"></s:property>
<br>

test : <s:property value="%{param}"></s:property>

</body>
</html>
