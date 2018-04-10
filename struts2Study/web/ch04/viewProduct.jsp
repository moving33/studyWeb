<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-04-10
  Time: 오후 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<meta name="viewport" content="width=device-width, initial-scale = 1.0"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
    제품정보조회
    <br><br>
    <s:text name="label.product.name"/>&nbsp;
    <s:property value="name"></s:property>
    <br>

    <%--<s:bean name="ch04.model.Product" var="product"/>--%>
    <s:text name="label.product.model_no"/>&nbsp;
    <s:property value="product"></s:property>

</body>
</html>
