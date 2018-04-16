<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-04-12
  Time: 오후 2:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form method="POST" action="/struts2/multiUploadList"
        enctype="multipart/form-data" theme="simple">
    배열을 이용한 다중 업로드
    <br>
    <br>
    file 1 : <s:file name="upload"/><br>
    file 2 : <s:file name="upload"/><br>
    file 3 : <s:file name="upload"/><br>
    <s:submit></s:submit>
</s:form>

</body>
</html>
