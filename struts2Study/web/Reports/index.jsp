<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-04-13
  Time: 오후 4:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <style type="text/css">
        button {
            background-color: #008CBA;
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            border-radius: 12px;
        }
    </style>
</head>
<body style="text-align: center;">
<h1>Struts2 and Jasper iReport Integration Example</h1>
<form method="POST" name="rpt" action="/struts2/StudentReport.action">

    <button type="submit" name="submit" value="pdf">Generate Report</button>

</form>
</body>
</html>