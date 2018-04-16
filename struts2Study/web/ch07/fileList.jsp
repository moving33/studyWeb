<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-04-12
  Time: 오후 2:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File Download</title>
</head>
<body>
파일 목록 ... <br><br>
베이스 디렉토리 : <s:property value="basePath"/><br><br>
<ul>
    <s:iterator value="listFile" status="stat">
        <s:url var="download" action="/struts2/fileDownload">
            <s:param name="basePath" value="basePath"></s:param>
            <s:param name="fileName" value="listFile[#stat.index].name"/>
        </s:url>
        <li>
            <s:a href="http://localhost:8080%{download}">
                <s:property value="listFile[#stat.index].name"/>
            </s:a>
            <br>
            <br>
        </li>
    </s:iterator>
</ul>
<br>
<br>
파일 다운시 클릭 이름

</body>
</html>
