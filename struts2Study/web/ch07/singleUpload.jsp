<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-04-12
  Time: 오전 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:actionerror/>
<s:fielderror/>

<s:form method="post" action="/struts2/singleUpload"
    enctype="multipart/form-data" theme="simple">
    단일 파일 업로드...
    <br>
    <br>
    <s:file name="upload"></s:file>
    <br>
    <br>
    <s:submit/>
</s:form>

</body>
</html>
