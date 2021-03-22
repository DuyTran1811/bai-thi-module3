<%--
  Created by IntelliJ IDEA.
  User: duytran
  Date: 3/21/21
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
      integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="style.css">
<html>
<head>
    <title>Create</title>
</head>
<body>
<style>
    .message {
        color: #0239c4;
    }
</style>
<div class="container">
    <div class="col-md-6 offset-5">
        <nav>
            <h1>Create Product</h1>
        </nav>
        <h2><a href="/product?action=product">Back List Product</a></h2>
    </div>
    <div class="col-md-6 offset-5">
        <p>
            <c:if test='${requestScope["message"] != null}'>
                <span class="message">${requestScope["message"]}</span>
            </c:if>
        </p>

        <form action="/product?action=create" method="post">
            <fieldset style="height: 250px; width: 300px">
                <legend>Thông Tin Thêm Sản Phẩm </legend>
                <div>
                    <tr>
                        <td>
                            <label>
                                <div>
                                    Tên Sản Phẩm
                                </div>
                                <input name="name" type="text"/>
                            </label>
                        </td>
                    </tr>
                </div>

                <div>
                    <tr>
                        <td>
                            <label>
                                <div>
                                    Giá Sản Phẩm
                                </div>
                                <input name="price" type="number"/>
                            </label>
                        </td>
                    </tr>
                </div>

                <div>
                    <tr>
                        <td>
                            <label>
                                <div>
                                    Số Lượng
                                </div>
                                <input name="quantity" type="number"/>
                            </label>
                        </td>
                    </tr>
                </div>

                <div>
                    <tr>
                        <td>
                            <label>
                                <div>
                                    Mầu
                                </div>
                                <input name="color" type="text"/>
                            </label>
                        </td>
                    </tr>
                </div>

                <div>
                    <tr>
                        <td>
                            <label>
                                <div>
                                    <label for="category1"> Danh Mục Sản Phẩm </label>
                                </div>
                                <select name="category" id="category1">
                                    <c:forEach items="${listca}" var="list">
                                        <option value="${list.id}">${list.name}</option>
                                    </c:forEach>
                                </select>
                            </label>
                        </td>
                    </tr>
                </div>
                <div>
                    <button class="btn btn-success" type="submit">Create</button>
                </div>
            </fieldset>
        </form>
    </div>
</div>
</body>
</html>
