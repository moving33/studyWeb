<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-04-12
  Time: 오전 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
단일 파일 업로드 결과 .. <br><br>
ContentsType : <s:property value="uploadContentType"/>
<br>
Local File name : <s:property value="uploadFileName" />
<br>
Server Context Path : <s:property value="serverFullPath" />
<br>
Temp File name : <s:property value="upload"/>
</body>
</html>
