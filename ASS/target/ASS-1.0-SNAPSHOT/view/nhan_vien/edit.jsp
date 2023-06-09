<%--
  Created by IntelliJ IDEA.
  User: BXT
  Date: 21/03/2023
  Time: 1:20 CH
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

<h1 style="text-align: center;">Nhân viên</h1>
<div class="col-8 offset-2">
    <form method="POST"
          action="/ASS_war_exploded/nhan-vien/update?ma=${ nv.ma }">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" value="${ nv.ma }" disabled />
            </div>
            <div class="col-6">
                <label>Họ</label>
                <input type="text" name="ho" class="form-control" value="${ nv.ho }"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Tên đệm</label>
                <input type="text" name="ten_dem" class="form-control" value="${ nv.tenDem }" />
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" value="${ nv.ten }" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Giới tính</label>
                <select name="gioi_tinh" class="form-select">
                    <option value="nam" ${ nv.gioiTinh == "nam" ? "selected" : "" }>nam</option>
                    <option value="nu" ${ nv.gioiTinh == "nu" ? "selected" : "" }>nữ</option>
                </select>
            </div>
            <div class="col-6">
                <label>Ngày sinh</label>
                <input type="date" name="ngay_sinh" class="form-control" value="${ nv.ngaySinh }" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="dia_chi" class="form-control" value="${ nv.diaChi }" />
            </div>
            <div class="col-6">
                <label>SDT</label>
                <input type="tel" name="sdt" class="form-control" value="${ nv.sdt }"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mật khẩu</label>
                <input type="password" name="mat_khau" class="form-control" value="${ nv.matKhau }"/>
            </div>
            <div class="col-6">
                <label>idCH</label>
                <select name="idCH" class="form-select">
                    <option value="maCH1001" ${ nv.cv == "maCH1001" ? "selected" : "" }>maCH1001</option>
                    <option value="maCH1002" ${ nv.cv == "maCH1002" ? "selected" : "" }>maCH1002</option>
                    <option value="maCH1003" ${ nv.cv == "maCH1003" ? "selected" : "" }>maCH1003</option>
                </select>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <label>idCH</label>
                <select name="idCH" class="form-select">
                    <option value="maCV1001" ${ nv.cuaHang == "maCV1001" ? "selected" : "" }>maCV1001</option>
                    <option value="maCV1002" ${ nv.cuaHang == "maCV1002" ? "selected" : "" }>maCV1002</option>
                    <option value="maCV1003" ${ nv.cuaHang == "maCV1003" ? "selected" : "" }>maCV1003</option>
                </select>
            </div>
            <div class="col-6">
                <label>trạng thái</label>
                <input type="text" name="trang_thai" class="form-control" value="${ nv.trangThai }"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary" >Câp Nhâp</button>
            </div>
            <div class="col-6"></div>
        </div>
    </form>


</div>
<script src="/ASS_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
