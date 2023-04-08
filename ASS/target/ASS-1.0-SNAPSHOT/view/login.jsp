<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 06/04/2023
  Time: 12:13 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/ASS_war_exploded/css/bootstrap.min.css" />

</head>
<br/>
<nav class="navbar navbar-expand-lg bg-light">
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
                <li class="nav-item" >
                    <a class="nav-link active" aria-current="page" href="/ASS_war_exploded/login">Đăng nhập</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="row mt-10" style="min-height: 500px;">
    <div class="col-2 bg-"></div>
    <div class="col-10">
        <div class="row">
            <h1 style="text-align: center">Đăng nhập</h1>
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <div class="mb-3">
                    <div class="alert alert-red">${ errorMessage }</div>
                    <form method="post" action="/ASS_war_exploded/login">
                        <div class="mt-3">
                            <label>Mã</label>
                            <input type="text" name="ma" class="form-control" />
                        </div>
                        <div class="mt-3">
                            <label>Mật khẩu</label>
                            <input type="password" name="matKhau" class="form-control" />
                        </div>
                        <div class="mt-3">
                            <button class="btn btn-primary">Đăng nhập</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-4"></div>
    </div>
    <script src="/ASS_war_exploded/js/bootstrap.min.js"></script>
</div>
