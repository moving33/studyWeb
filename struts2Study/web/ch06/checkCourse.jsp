<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-04-11
  Time: 오후 3:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form action="/struts2/checkCourse" theme="simple">
    교육과목을 선택해주세요
    <br>
    <s:checkbox name="struts2" value="%{struts2}"/>Struts2
    <s:checkbox name="spring" value="%{spring}"/>Spring
    <s:checkbox name="ibatis" value="%{ibatis}"/>iBatis
    <s:checkbox name="android" value="%{android}"/>iBatis
    <br><br>
    Struts2(<s:property value="struts2"/>):<s:property value="struts2 ? '선택':'아니오'"/>
    <br>
    Spring(<s:property value="spring"/>):<s:property value="spring ? '선택':'아니오'"/>
    <br>
    iBatis(<s:property value="ibatis"/>):<s:property value="ibatis ? '선택':'아니오'"/>
    <br>
    android(<s:property value="android"/>):<s:property value="android ? '선택':'아니오'"/>
    <br>
    <s:submit/>
</s:form>
</body>
</html>
