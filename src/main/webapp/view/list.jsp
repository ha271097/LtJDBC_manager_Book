<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 5/29/2021
  Time: 7:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Show List Book</title>
</head>
<body>
<h1>List Book</h1>
<a href="home?action=create">ADD NEW BOOK</a>
<table border="1px solid">
    <tr>
        <td>Name </td>
        <td>Price</td>
        <td>LoaiSach</td>
        <td>Edit</td>
    </tr>
    <c:forEach items="${listBook}" var="list">
        <tr>
            <td>${list.name}</td>
            <td>${list.price}</td>
            <td>${list.loaisach.name}</td>
            <td><a href="home?action=edit&id=${list.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
