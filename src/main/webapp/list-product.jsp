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
            margin-left: 500px;
        }

        a {
            color: black;
            text-decoration: none;
            font-weight: bold;
        }

        input {
            border-radius: 4px;
        }

        form {
            float: right;
        }
    </style>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
<div class="container">
    <h1>List product</h1>
    <h2><c:out value="${message}"/></h2>
    <a href="create-product.jsp">
        <button style="margin-bottom: 10px" class="btn btn-primary">
            Add new product
        </button>
    </a>
    <form action="products?action=search" method="post">
        <input type="text" name="search" placeholder="Enter name search">
        <button class="btn btn-primary">Search</button>
    </form>
    <table class="table table-striped">
        <tr>
            <th>STT</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th colspan="2" style="text-align: center; width: 25%">Action</th>
        </tr>
        <c:forEach items="${products}" var="p">
            <tr>
                <td><c:out value="${p.getId()}"/></td>
                <td>
                    <a href="/products?action=detail&id=${p.getId()}">
                        <c:out value="${p.getName()}"/>
                    </a>
                </td>
                <td><c:out value="${p.getPrice()}"/></td>
                <td><c:out value="${p.getQuantity()}"/></td>
                <td>
                    <a href="products?action=update&id=${p.getId()}">
                        <button class="btn btn-warning">
                            Update
                        </button>
                    </a>
                </td>
                <td>
                    <a href="products?action=delete&id=${p.getId()}" onclick="return a(${p.getId()}, ${p.getName()})">
                        <button class="btn btn-danger">
                            Delete
                        </button>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
<script>
    function a(id, name) {
        Swal.fire({
            title: 'Do you want to delete product: ' + name + ' ?',
            showDenyButton: true,
            showCancelButton: false,
            confirmButtonText: 'Delete',
            denyButtonText: `Cancel`,
            timer: 5000
        }).then((result) => {
            if (result.isConfirmed) {
                Swal.fire({
                    title: 'Delete successfully!',
                    timer: 2500
                })
                check(id)
            } else if (result.isDenied) {
            }
        })
        return false;
    }

    function check(id) {
        window.location.href = "http://localhost:8080/products?action=delete&id=" + id;
    }
</script>
</html>

