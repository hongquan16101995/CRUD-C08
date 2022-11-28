<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/28/2022
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<form action="/products?action=create" method="post">
    <table>
        <tr>
            <th><label for="name">Name</label></th>
            <td><input type="text" id="name" name="name"></td>
        </tr>
        <tr>
            <th><label for="price">Price</label></th>
            <td><input type="text" id="price" name="price"></td>
        </tr>
        <tr>
            <th><label for="quantity">Quantity</label></th>
            <td><input type="text" id="quantity" name="quantity"></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit">Create</button>
                <button><a href="/products">Back</a></button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
