<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/29/2022
  Time: 10:45 AM
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
    <h1>Update form</h1>
    <form method="post">
        <input type="text" value="${product.getId()}" name="id" hidden>
        <div class="mb-3 mt-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" value="${product.getName()}"
                   id="name" placeholder="Enter name" name="name">
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Price</label>
            <input type="text" class="form-control" value="${product.getPrice()}"
                   id="price" placeholder="Enter price" name="price">
        </div>
        <div class="mb-3">
            <label for="quantity" class="form-label">Quantity</label>
            <input type="text" class="form-control" value="${product.getQuantity()}"
                   id="quantity" placeholder="Enter quantity" name="quantity">
        </div>
        <div class="mb-3">
            <label for="category" class="form-label">Category</label>
            <select class="form-control" id="category" name="category">


                <c:forEach items="${categories}" var="c">
                    <c:if test="${c.getId() != product.getCategory().getId()}">
                        <option value="${c.getId()}"><c:out value="${c.getName()}"/></option>
                    </c:if>
                    <c:if test="${c.getId() == product.getCategory().getId()}">
                        <option selected value="${c.getId()}"><c:out value="${c.getName()}"/></option>
                    </c:if>
                </c:forEach>
<%--                Đỗ minh đức--%>
                <%--                <option hidden selected--%>
                <%--                        value="${requestScope["product"].getCategory().getId()}">--%>
                <%--                    ${requestScope["product"].getCategory().getName()}--%>
                <%--                </option>--%>
                <%--                <c:forEach items="${categories}" var="c">--%>
                <%--                      <option value="${c.getId()}"><c:out value="${c.getName()}"/></option>--%>
                <%--                </c:forEach>--%>
            </select>
        </div>
        <div class="mb-3">
            <button type="submit" class="btn btn-primary">Update</button>
            <a href="pcs">
                <button type="button" class="btn btn-secondary">Cancel</button>
            </a>
        </div>
    </form>
</div>
</body>
</html>
