<%--
  Created by IntelliJ IDEA.
  User: BXT
  Date: 20/03/2023
  Time: 11:47 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <center>
            <h1>Chi Tiết Sản Phẩm</h1>
        </center>
    </div>
    <div class="col-md-4"></div>
</div>
<br>
<div>
    <div class="row">
        <div class="col-6">
            <a href="/ASS_war_exploded/chi-tiet-sp/create" class="btn btn-success">Thêm mới</a>
        </div>
    </div>
    <c:if test="${ f:length(danhSachchiTietSP) == 0 }">
        <h3 class="alert-warning">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${ f:length(danhSachchiTietSP) != 0 }">
        <table class="table table-striped mt-3">
            <thead class="table">
            <tr>
                <th>Id</th>
                <th>Sản Phẩm</th>
                <th>Nhà Sản Xuất</th>
                <th>Màu Sắc</th>
                <th>Dòng Sản Phẩm</th>
                <th>Năm Bảo Hành</th>
                <th>Mô Tả</th>
                <th>Số Lượng Tồn</th>
                <th>Giá Nhập</th>
                <th>Giá Bán</th>
                <th colspan="2">Thao tác</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${ danhSachchiTietSP }" var="ct">
                <tr>
                    <td>${ ct.id }</td>
                    <td>${ ct.sp.ten }</td>
                    <td>${ ct.nsx.ten }</td>
                    <td>${ ct.ms.ten }</td>
                    <td>${ ct.dongsp.ten }</td>
                    <td>${ ct.namBH }</td>
                    <td>${ ct.moTa }</td>
                    <td>${ ct.soLuongTon }</td>
                    <td>${ ct.giaNhap }</td>
                    <td>${ ct.giaBan }</td>
                    <td>
                        <a class="btn btn"
                           href="/ASS_war_exploded/chi-tiet-sp/edit?ma=${ ct.id }">
                            Cập nhật
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-danger"
                           href="/ASS_war_exploded/chi-tiet-sp/delete?ma=${ ct.id }">
                            Xóa
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
