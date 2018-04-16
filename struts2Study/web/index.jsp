
<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-04-10
  Time: 오후 5:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>Title</title>

  </head>
  <body>
  <!-- action Tag -->

  <table style="    width: 75%;
    text-align: center;">
    <tr>
      <th>
        CH04
      </th>

      <th>
        CH05
      </th>

      <th>
        CH06
      </th>

      <th>
        CH07
      </th>

      <th>
        CH08
      </th>
    </tr>

    <tr>
      <td>
        <s:a action="actionSupport" namespace="http://localhost:8080/struts2">Action Support Ex</s:a>
      </td>

      <td>
        <s:a action="UserRegForm" namespace="http://localhost:8080/struts2">UserRegForm Ex </s:a>
      </td>

      <td>
        <s:a action="checkCourse" namespace="http://localhost:8080/struts2">check box Ex </s:a>
      </td>

      <td>
        <s:a action="goSingleUpload" namespace="http://localhost:8080/struts2">File Upload Ex </s:a>
      </td>

      <td>
        <s:a action="visitChart" namespace="http://localhost:8080/struts2">Chart Ex </s:a>
      </td>
    </tr>

    <tr>
      <td>
        <s:a action="addProductForm" namespace="http://localhost:8080/struts2">action Chain Ex </s:a>
      </td>

      <td>
        <s:a action="LoginOne" namespace="http://localhost:8080/struts2">Dispatcher,redirect Ex </s:a>
      </td>

      <td>
        <s:a action="movieRank" namespace="http://localhost:8080/struts2">list Movie Ex </s:a>
      </td>

      <td>
        <s:a action="goMultiUpload" namespace="http://localhost:8080/struts2">File Array upload Ex </s:a>
      </td>
    </tr>

    <tr>
      <td>
        <s:a action="callMultiAction" namespace="http://localhost:8080/struts2">Multi Action Ex </s:a>
      </td>

      <td>
        <s:a action="MyRegForm" namespace="http://localhost:8080/struts2">action and redirect connect Ex </s:a>
      </td>

      <td>
        <s:a action="appendList" namespace="http://localhost:8080/struts2">Append List </s:a>
      </td>

      <td>
        <s:a action="fileList" namespace="http://localhost:8080/struts2">file Download Ex </s:a>
      </td>
    </tr>

    <tr>
      <td>
        <s:a action="RegFormAction" namespace="http://localhost:8080/struts2">RegFormAction Ex </s:a>
      </td>

      <td>

      </td>

      <td>

      </td>

      <td>
        <s:a action="goFieldValidator" namespace="http://localhost:8080/struts2">validator Ex </s:a>
      </td>
    </tr>

    <tr>
      <td>
        <s:a action="DispatcherAction" namespace="http://localhost:8080/struts2">DispatcherAction Ex </s:a>
      </td>

      <td>

      </td>

      <td>

      </td>

      <td>
        <s:a action="nonFieldValidator" namespace="http://localhost:8080/struts2">nonFieldValidator Ex </s:a>
      </td>
    </tr>
  </table>
  </body>
</html>
