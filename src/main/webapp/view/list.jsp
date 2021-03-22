<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<header>
    <div id="container">
        <nav>
            <h1>List Product</h1>
        </nav>
    </div>
</header>


<div>
    <a href="/product?action=create" methods="post">
        <button class="btn btn-info">ADD</button>
    </a>
    <div style="float: right">
        <form action="/product?action=search" method="post">
            <input type="text" name="name" placeholder="Nhap Ten Can Tim"/>
            <button class="btn btn-success">Search</button>
        </form>
    </div>
</div>

<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Price</th>
        <th scope="col">Quantity</th>
        <th scope="col">Color</th>
        <th scope="col">Category</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listProduct}" var="list">
        <tr>
            <th scope="row">${list.id}</th>
            <td>${list.name}</td>
            <td>${list.price}</td>
            <td>${list.quantity}</td>
            <td>${list.color}</td>
            <td>${list.category}</td>
            <td>
                <a href="/product?action=delete&id=${list.id}">
                    <button class="btn btn-danger">Delete</button>
                </a>
                <a href="/product?action=update&id=${list.id}">
                    <button class="btn btn-secondary">Edit</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
