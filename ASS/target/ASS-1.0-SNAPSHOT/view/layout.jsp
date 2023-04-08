<%--
  Created by IntelliJ IDEA.
  User: BXT
  Date: 21/03/2023
  Time: 2:50 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/ASS_war_exploded/css/bootstrap.min.css" />
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-secondary">
    <div class="container-fluid">
        <a class="navbar-brand" href=""></a>
        <a class="navbar-brand" href=""></a>
        <a class="navbar-brand" href="#"></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarNav" aria-controls="navbarNav"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="create">khách hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="san-pham/create">sản phẩm</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="ASS_war_exploded/khach-hang/create">Trang chủ</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="row mt-10" style="min-height: 500px;">
    <div class="col-2 bg">
        <a class="navbar-brand" href="/ASS_war_exploded/khach-hang/index">Khách Hàng</a>
        <br>
        <a class="navbar-brand" href="/ASS_war_exploded/san-pham/index">Sản phẩm</a>
        <br>
        <a class="navbar-brand" href="/ASS_war_exploded/Nsx/index">NSX</a>
        <br>
        <a class="navbar-brand" href="/ASS_war_exploded/DongSP/index">DongSP</a>
        <br>
        <a class="navbar-brand" href="/ASS_war_exploded/mau-sac/index">Màu sắc</a>
        <br>
        <a class="navbar-brand" href="/ASS_war_exploded/nhan-vien/index">nhân viên</a>
        <br>
        <a class="navbar-brand" href="/ASS_war_exploded/cua-hang/index">cua hang </a>
        <br>
        <a class="navbar-brand" href="/ASS_war_exploded/chuc-vu/index">chuc vu</a>
        <br>
        <a class="navbar-brand" href="/ASS_war_exploded/chi-tiet-sp/index">chi tiet SP</a></div>
    <div class="col-10 bg">
        <jsp:include page="${ view }" />
    </div>
</div>



            <footer class="container-fluid text-bg-secondary text-center">
                <p>Trần Viết Thành An</p>
                <a style="color: white"  href="https://www.facebook.com/"><i class="fa fa-facebook-square"></i></a></i>
                <a style="color: white" href="https://www.instagram.com//"><i class="fa fa-instagram"></i></a></i>
            </footer>



<script src="/ASS_war_exploded/js/bootstrap.min.js"></script>


</body>
</html>
