<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-04-11
  Time: 오후 3:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<s:form action="/struts2/selectCourse" theme="simple">
    교육 과목을 선택하세요 <br><br>
    Ex One : String List <br>
    <s:select list="listCourseExOne" name="listCheckExOne" multiple="true"/>
    <br>
    선택된 값 :
    <s:iterator value="listCheckExOne">
        <s:property/>&nbsp;
    </s:iterator>
    <br>
    <br>
    <hr>

    Ex Two : Hash Map <br>
    <s:select list="mapCourseExTwo" name="checkExTwo" headerKey="" headerValue="--선택 하세요 --"/>
    <br>
    선택된 값 :
    <s:property value="checkExTwo"/>
    <br>
    <hr>

    Ex Three : Object <br>
    <s:select list="lisCourseExThree" name="checkExThree" listKey="id" listValue="name"
              headerKey="" headerValue="--선택 하세요--"/>
    <br>
    선택된 값 : <s:property value="checkExThree"/>
    <br>
    <br>
    <s:submit/>
</s:form>

</body>
</html>
