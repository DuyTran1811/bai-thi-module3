<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="col-md-6 offset-5">
    <form action="/product?action=update&id=${pro.id}" method="post">
        <fieldset style="height: 250px; width: 300px">
            <legend>Thông Tin Thêm Sản Phẩm</legend>

            <div>
                <tr>
                    <td>
                        <label>
                            <div>
                                Tên Sản Phẩm
                            </div>
                            <input name="name" type="text" value="${pro.name}"/>
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
                            <input name="price" type="number" value="${pro.price}"/>
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
                            <input name="quantity" type="number" value="${pro.quantity}"/>
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
                            <input name="color" type="text" value="${pro.color}"/>
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
                                <option value="1">APPLE</option>
                                <option value="2">SAMSUNG</option>
                                <option value="3">OOPO</option>
                            </select>
                        </label>
                    </td>
                </tr>
            </div>
            <div>
                <button class="btn btn-success" type="submit">Sever</button>
            </div>
        </fieldset>
    </form>
    </div>
</div>
</body>
</html>
