<%--
  Created by IntelliJ IDEA.
  User: lukas_6pzbkp8
  Date: 3/9/2020
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin dashboard</title>
</head>
<body>
<h1>Admin dashboard</h1>
<ul>
    <c:forEach items="${library}" var="book">
        <li>
            <c:out value="${book.toString()}"></c:out>
            <form method="post" action="library">
                <input type="hidden" value="delete" name="action">
                <input type="hidden" value="${book.id}" name="id">
                <input type="submit" value="Delete">
            </form>
        </li>
    </c:forEach>
</ul>
<h2>Add new book</h2>
<form method="post" action="library">
    <input type="hidden" value="add" name="action">
    <label>
        Author:
        <input type="text" name="author">
    </label>
    <label>
        Title:
        <input type="text" name="title">
    </label>
    <label>
        Date published:
        <input type="date" name="publishedOn">
    </label>
    <input type="submit">
</form>
</body>
</html>
