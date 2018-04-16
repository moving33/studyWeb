
<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-04-12
  Time: 오후 4:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
모든 필드 오류 : <br>
<s:fielderror/>
<hr/>
필수 입력 문자열 오류 (requiredStringValidator) : <br>
<s:fielderror>
    <s:param value="%{'requiredStringValidator'}"/>
</s:fielderror>
<b>문자열 길이 오류</b> : <br>
<s:fielderror>
    <s:param value="%{'stringLengthValidator'}"/>
</s:fielderror>
<hr>
<s:form action="/struts2/fieldValidator" theme="xhtml">
    <s:textfield label="Required Validator" name="requiredValidator"/>
    <s:textfield label="Required String Validator" name="requiredStringValidator"/>
    <s:textfield label="Integer Validator" name="integerValidator"/>
    <s:textfield label="Email Validator" name="emailValidator"/>
    <s:textfield label="URL Validator" name="urlValidator"/>
    <s:textfield label="String Length Validator" name="stringLengthValidator"/>
    <s:textfield label="Regx Validator" name="regexValidator"/>
    <s:textfield label="Field Expression Validator" name="fieldExpressionValidator"/>
    <br>
    <s:submit></s:submit>
</s:form>

</body>
</html>
