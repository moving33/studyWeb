<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-04-27
  Time: 오후 5:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>simpleTestForm</title>
</head>
<body>
<form method="post">
    이름:<input type="text" name="name" />
    <br>
    나이:<input type="text" name="age" />
    <input type="submit">
</form>

<br>
<br>
<h3>Data Type으로</h3>
<form method="post" action="/ch20/test/simpleTestData.do">
    이름:<input type="text" name="name" />
    <br>
    나이:<input type="text" name="age" />
    <input type="submit">
</form>

</body>
</html>
