<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/28/2022
  Time: 3:37 PM
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
        h1 {
            margin-left: 450px;
        }

        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>List product</h1>
    <button class="btn btn-primary">
        <a style="color: white; font-weight: bold"
           href="create-product.jsp">Add new product</a>
    </button>
    <table class="table table-striped">
        <tr>
            <th>STT</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
        </tr>
        <c:forEach items="${products}" var="p">
            <tr>
                <td><c:out value="${p.getId()}"/></td>
                <td><a href="/products?action=detail&id=${p.getId()}"><c:out value="${p.getName()}"/></a></td>
                <td><c:out value="${p.getPrice()}"/></td>
                <td><c:out value="${p.getQuantity()}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
