<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-04-12
  Time: 오전 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
배열을 사용한 다중 업로드 결과 ...
<s:iterator value="upload" status="stat">
    <br>
    file : <s:property value="%{#stat.index+1}"/>
    <br>
    Contents Type : <s:property value="%{uploadContentType[#stat.index]}"/>
    <br>
    Local File name : <s:property value="%{uploadFileName[#stat.index]}"/>
    <br>
    서버 전체 경로 : <s:property value="%{serverFullPath[#stat.index]}"/>
    <br>
    임시 파일 이름 : <s:property value="%{upload[#stat.index]}"/>
    <br>
    파일 용량 : <s:property value="%{uploadContentLength[#stat.index]}"/>
    <hr>

</s:iterator>
</body>
</html>
