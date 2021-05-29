<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 5/29/2021
  Time: 10:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Edit Book</title>
</head>
<body>
<h1>Edit Book</h1>
<form method="post"><table>
    <tr> <td>Name: </td>
        <td><input type="text" name="name" value="${oldBook.name}" ></td>
    </tr>
    <tr> <td>Price: </td>
        <td><input type="text" name="price" value="${oldBook.price}"> </td>
    </tr>
    <tr>
        <td>LoaiSach: </td>
        <td><c:forEach items="${listLS}" var="LLS">
            <input type="radio" id="${LLS.id}" name="loaisach" value="${LLS.id}">
            <label>${LLS.name}</label>
        </c:forEach>
        </td>
    </tr>
</table>
    <input type="submit" value="Edit">
</form>
</body>
</html>
