<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/28/2022
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <style>
        div {
            margin: auto;
            width: 500px;
        }
    </style>
</head>
<body>
<div>
    <h1>Product Detail</h1>
    <table class="table table-striped">
        <tr>
            <th>STT</th>
            <td><c:out value="${product.getId()}"/></td>
        </tr>
        <tr>
            <th>Name</th>
            <td><c:out value="${product.getName()}"/></td>
        </tr>
        <tr>
            <th>Price</th>
            <td><c:out value="${product.getPrice()}"/></td>
        </tr>
        <tr>
            <th>Quantity</th>
            <td><c:out value="${product.getQuantity()}"/></td>
        </tr>
        <tr>
            <th>Category</th>
            <td><c:out value="${product.getCategory().getName()}"/></td>
        </tr>
    </table>
    <a href="/products">
        <button class="btn btn-secondary">
            Back
        </button>
    </a>
</div>
</body>
</html>
