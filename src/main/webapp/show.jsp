<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/1/11
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生信息</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
        <table class="tt">
          <tr>
            <th>id</th>
            <th>name</th>
            <th>address</th>
            <th>option</th>
          </tr>
          <c:forEach items="${st}" var="s">
              <tr>
                  <td>${s.id}</td>
                  <td>${s.name}</td>
                  <td>${s.address}</td>
                  <td><a href="?id=${s.id}">删除</a></td>
              </tr>

          </c:forEach>

        </table>

</body>
</html>
