<%--
  Created by IntelliJ IDEA.
  User: BXT
  Date: 14/03/2023
  Time: 5:34 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--    <link rel="stylesheet"--%>
<%--          href="/ASS_war_exploded/css/bootstrap.min.css"/>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1 style="text-align: center;">San Pham</h1>--%>
<%--<div class="col-8 offset-2 mt-5 table-responsive">--%>
<%--    <div class="row">--%>
<%--        <div class="col-6">--%>
<%--            <a href="create" class="btn btn-success">Thêm mới</a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <c:if test="${ f:length(danhSachSP) == 0 }">--%>
<%--        <h3 class="alert alert-warning">Không có dữ liệu</h3>--%>
<%--    </c:if>--%>
<%--    <c:if test="${ f:length(danhSachSP) != 0 }">--%>
<%--        <table class="table table-striped mt-3">--%>
<%--            <thead class="table-primary">--%>
<%--            <tr>--%>
<%--                <th>ID</th>--%>
<%--                <th>Mã</th>--%>
<%--                <th>Tên</th>--%>
<%--                <th colspan="2">Thao tác</th>--%>
<%--            </tr>--%>
<%--            </thead>--%>
<%--            <tbody>--%>

<%--            <c:forEach items="${ danhSachSP }" var="kh">--%>
<%--                <tr>--%>
<%--                    <td>${ kh.id }</td>--%>
<%--                    <td>${ kh.ma }</td>--%>
<%--                    <td>${ kh.ten }</td>--%>
<%--                    <td>--%>
<%--                        <a class="btn btn-primary"--%>
<%--                           href="/ASS_war_exploded/san-pham/edit?ma=${ kh.ma }">--%>
<%--                            Cập nhật--%>
<%--                        </a>--%>
<%--                    </td>--%>
<%--                    <td>--%>
<%--                        <a class="btn btn-danger"--%>
<%--                           href="/ASS_war_exploded/san-pham/delete?ma=${ kh.ma }">--%>
<%--                            Xóa--%>
<%--                        </a>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--            </tbody>--%>
<%--        </table>--%>
<%--    </c:if>--%>

<%--</div>--%>
<%--<script src="/ASS_war_exploded/js/bootstrap.min.js"></script>--%>
<%--</body>--%>
<%--</html>--%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="/ASS_war_exploded/css/bootstrap.min.css"/>
</head>
<body>
<h1 style="text-align: center;">SP</h1>
<div class="col-8 offset-2 mt-5 table-responsive">
    <div class="row">
        <div class="col-6">
            <a href="create" class="btn btn-success">Thêm mới</a>
        </div>
    </div>
    <c:if test="${ f:length(danhSachSP) == 0 }">
        <h3 class="alert alert-warning">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${ f:length(danhSachSP) != 0 }">
        <table class="table table-striped mt-3">
            <thead class="table-primary">
            <tr>
                <th>ID</th>
                <th>Mã</th>
                <th>Tên</th>
                <th colspan="2">Thao tác</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${ danhSachSP }" var="kh">
                <tr>
                    <td>${ kh.id }</td>
                    <td>${ kh.ma }</td>
                    <td>${ kh.ten }</td>
                    <td>
                        <a class="btn btn-primary"
                           href="/ASS_war_exploded/san-pham/edit?ma=${ kh.ma }">
                            Cập nhật
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-danger"
                           href="/ASS_war_exploded/san-pham/delete?ma=${ kh.ma }">
                            Xóa
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

</div>



<script src="/ASS_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
