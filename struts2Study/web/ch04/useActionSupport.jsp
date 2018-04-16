<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-04-10
  Time: 오후 5:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Locale,Resoruce Bundle use</title>
</head>
<body>
<s:property value="myLocale.displayCountry"/>
<br>
<s:property value="myLocale.displayLanguage"/>
<br>
<s:property value="message"/>
</body>
</html>
