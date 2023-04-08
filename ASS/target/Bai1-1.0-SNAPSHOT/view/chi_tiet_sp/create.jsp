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
          href="/Bai1_war_exploded/css/bootstrap.min.css"/>
</head>
<body>

<h1 style="text-align: center;">Chi tiết sp</h1>

<div class="col-8 offset-2">
    <form method="POST"
          action="/Bai1_war_exploded/chi-tiet-sp/store">
        <div class="row mt-3">
            <div class="col-6">
                <label>id</label>
                <input type="text" name="id" class="form-control" />
            </div>
            <div class="col-6">
                <label>IdSP</label>
                <select name="idSP" class="form-select">
                    <option value="maSP1001">maSP1001</option>
                    <option value="maSP1002">maSP1002</option>
                    <option value="maSP1003">maSP1003</option>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>IdNsx</label>
                <select name="idNsx" class="form-select">
                    <option value="maNsx1001">maNsx1001</option>
                    <option value="maNsx1002">maNsx1002</option>
                    <option value="maNsx1003">maNsx1003</option>
                </select>
            </div>
            <div class="col-6">
                <label>IdMauSac</label>
                <select name="idMS" class="form-select">
                    <option value="maMS1001">maMS1001</option>
                    <option value="maMS1002">maMS1002</option>
                    <option value="maMS1003">maMS1003</option>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>IdDongSP</label>
                <select name="idDongSP" class="form-select">
                    <option value="maDongSP1001">maDongSP1001</option>
                    <option value="maDongSP1002">maDongSP1002</option>
                    <option value="maDongSP1003">maDongSP1003</option>
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
        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary" >Thêm mới</button>
            </div>
            <div class="col-6"></div>
        </div>
    </form>


</div>
<script src="/Bai1_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
