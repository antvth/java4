<%--
  Created by IntelliJ IDEA.
  User: BXT
  Date: 20/03/2023
  Time: 11:47 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="/ASS_war_exploded/css/bootstrap.min.css"/>
</head>
<body>

<h1 style="text-align: center;">Chi tiết sp</h1>

<div class="col-8 offset-2">
    <form method="POST"
          action="/ASS_war_exploded/chi-tiet-sp/store">
        <div class="row mt-3">
            <div class="col-6">
                <label>id</label>
                <input type="text" name="id" class="form-control" />
            </div>
            <div class="col-6">
                <label>IdSP</label>
                <select name="idSP" class="form-select">
                    <option value="MaSP1001">MaSP1001</option>
                    <option value="MaSP1002">MaSP1002</option>
                    <option value="MaSP1003">MaSP1003</option>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>IdNsx</label>
                <select name="idNsx" class="form-select">
                    <option value="MaNsx1001">MaNsx1001</option>
                    <option value="MaNsx1002">MaNsx1002</option>
                    <option value="MaNsx1003">MaNsx1003</option>
                </select>
            </div>
            <div class="col-6">
                <label>IdMauSac</label>
                <select name="idMS" class="form-select">
                    <option value="MaMS1001">MaMS1001</option>
                    <option value="MaMS1002">MaMS1002</option>
                    <option value="MaMS1003">MaMS1003</option>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>IdDongSP</label>
                <select name="idDongSP" class="form-select">
                    <option value="MaDongSP1001">MaDongSP1001</option>
                    <option value="MaDongSP1002">MaDongSP1002</option>
                    <option value="MaDongSP1003">MaDongSP1003</option>
                </select>
            </div>
            <div class="col-6">
                <label>NamBH</label>
                <input type="tel" name="nam_bh" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>MoTa</label>
                <input type="text" name="mo_ta" class="form-control" />
            </div>
            <div class="col-6">
                <label>SoLuongTon</label>
                <input type="text" name="slton" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>GiaNhap</label>
                <input type="text" name="gia_nhap" class="form-control" />
            </div>
            <div class="col-6">
                <label>GiaBan</label>
                <input type="text" name="gia_ban" class="form-control" />
            </div>
        </div>
        <div class="alert text-center">${ errorMessage }</div>
        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary" >Thêm mới</button>
            </div>
            <div class="col-6"></div>
        </div>
    </form>


</div>
<script src="/ASS_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
