
<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-05-01
  Time: 오전 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hello!</title>
</head>
<body>

<h1>
    HELLO!!! SPRING!!!
    한글 깨지나요 안녕하세요!
    <br>
    ${test}
    <br>
    ${count}
</h1>

<c:forEach var="vo" items="${list}">
    <tr>
        <td>
            ${vo.num}&nbsp;&nbsp;${vo.subject}&nbsp;&nbsp;${vo.content}&nbsp;&nbsp;${vo.regdate}
        </td>
    </tr>
</c:forEach>

</body>
</html>
