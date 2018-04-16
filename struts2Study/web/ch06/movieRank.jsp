<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-04-11
  Time: 오후 3:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:label>Movie List</s:label>
<table border="1" style="height: 200px; width: 35%" >
    <tr>
        <th>장르</th>
        <th>제목</th>
        <th>포스터</th>
    </tr>
    <s:iterator value="listMovie">
        <tr style="text-align: center">
            <td>
                <s:property value="id"/>
            </td>

            <td>
                <s:property value="title"/>
            </td>

            <td>
                <s:if test="level==5">
                    <img src="\ch06\image/galaxy.jpeg" width="175" height="200"
                         border="0"/>
                </s:if>

                <s:elseif test="level==4">
                    <img src="\ch06\image/gonziam.jpg" width="175" height="200"
                         border="0"/>
                </s:elseif>

                <s:elseif test="level==3">
                    <img src="\ch06\image/aboutTime.jpeg" width="175" height="200"
                         border="0"/>
                </s:elseif>

                <s:elseif test="level==2">
                    <img src="\ch06\image/thor.jpg" width="175" height="200"
                         border="0"/>
                </s:elseif>

                <s:elseif test="level==1">
                    <img src="\ch06\image/DarkKnight.jpeg" width="175" height="200"
                         border="0"/>
                </s:elseif>
            </td>
        </tr>
    </s:iterator>
</table>

</body>
</html>
