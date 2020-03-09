<%--
  Created by IntelliJ IDEA.
  User: lukas_6pzbkp8
  Date: 3/9/2020
  Time: 6:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
<h1>User dashboard</h1>
<ul>
    <c:forEach items="${library}" var="book">
        <li>
            <c:out value="${book.toString()}"></c:out>
        </li>
    </c:forEach>
</ul>
</body>
</html>
