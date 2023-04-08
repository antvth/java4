package controller;

import Repository.NhanVienRepository;
import domain_model.MauSac;
import domain_model.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import view_model.QLNhanVien;

import java.io.IOException;

@WebServlet({
        "/nhan-vien/index",    // GET
        "/nhan-vien/create",   // GET
        "/nhan-vien/edit",     // GET
        "/nhan-vien/delete",   // GET
        "/nhan-vien/store",    // POST
        "/nhan-vien/update",   // POST
})
public class NhanVienServlet extends HttpServlet {
    private NhanVienRepository nvRepo;

    public NhanVienServlet()
    {
        this.nvRepo = new NhanVienRepository();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
            this.edit(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma  =  request.getParameter("ma");
        NhanVien domainModelNV = this.nvRepo.findByMa(ma);
        request.setAttribute("nv", domainModelNV);
//        request.getRequestDispatcher("/view/nhan_vien/edit.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/nhan_vien/edit.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma  =  request.getParameter("ma");
        NhanVien domainModelNV = this.nvRepo.findByMa(ma);
        this.nvRepo.delete(domainModelNV);
        response.sendRedirect("/ASS_war_exploded/nhan-vien/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachNV", this.nvRepo.findAll());
//        request.getRequestDispatcher("/view/nhan_vien/index.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/nhan_vien/index.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
//        request.getRequestDispatcher("/view/nhan_vien/create.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/nhan_vien/create.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            response.sendRedirect("/ASS_war_exploded/nhan-vien/index");
        }
    }

    protected void store(
//            HttpServletRequest request,
//            HttpServletResponse response
//    ) throws ServletException, IOException {
//        String ma = request.getParameter("ma");
//        String ho = request.getParameter("ho");
//        String ten_dem = request.getParameter("ten_dem");
//        String ten = request.getParameter("ten");
//        String gioi_tinh = request.getParameter("gioi_tinh");
//        String ngay_sinh = request.getParameter("ngay_sinh");
//        String dia_chi = request.getParameter("dia_chi");
//        String sdt = request.getParameter("sdt");
//        String mat_khau = request.getParameter("mat_khau");
//        String idCH = request.getParameter("idCH");
//        String idCV = request.getParameter("idCV");
//        String trang_thai = request.getParameter("trang_thai");
//
//        QLNhanVien vm = new QLNhanVien(ma, ho, ten_dem, ten,gioi_tinh, ngay_sinh, dia_chi, sdt, mat_khau,idCH,idCV,trang_thai);
//        this.nvRepo.insert(vm);
//        response.sendRedirect("/ASS_war_exploded/nhan-vien/index");
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {

//            String ma = request.getParameter("ma");
//            String ten = request.getParameter("ten");
//            String ho = request.getParameter("ho");
//            String tenDem = request.getParameter("tenDem");
//            String gioiTinh = request.getParameter("gioiTinh");
//            String ngaySinh = request.getParameter("ngaySinh");
//            String diaChi = request.getParameter("diaChi");
//            String sdt = request.getParameter("sdt");
//            String matKhau = request.getParameter("matKhau");
//            String cv = request.getParameter("cv");
//            String cuaHang = request.getParameter("cuaHang");
//            String trangThai = request.getParameter("trangThai");




//            HttpSession session = request.getSession();
//            if (ma.trim().equals("") || ten.trim().equals("")|| ho.trim().equals("") || tenDem.trim().equals("") || gioiTinh.trim().equals("")|| ngaySinh.trim().equals("") || diaChi.trim().equals("") || sdt.trim().equals("") || matKhau.trim().equals("") || cv.trim().equals("") || cuaHang.trim().equals("") ||  trangThai.trim().equals("")   ) {
//                session.setAttribute("errorMessage2", "Vui Lòng Không Để Trống Thông Tin");
//                response.sendRedirect("/ASS_war_exploded/nhan-vien/create");
//            } else {
                NhanVien domainModelCV = new NhanVien();
                BeanUtils.populate(domainModelCV, request.getParameterMap());
                this.nvRepo.insert(domainModelCV);
                response.sendRedirect("/ASS_war_exploded/nhan-vien/index");


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void update(
//            HttpServletRequest request,
//            HttpServletResponse response
//    ) throws ServletException, IOException {
//        try {
//            QLNhanVien vm = new QLNhanVien();
//            BeanUtils.populate(vm, request.getParameterMap());
//            this.nvRepo.update(vm);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        response.sendRedirect("/ASS_war_exploded/nhan-vien/index");
//    }
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma  =  request.getParameter("ma");
            NhanVien domainModelNV = this.nvRepo.findByMa(ma);
            BeanUtils.populate(domainModelNV, request.getParameterMap());
            this.nvRepo.update(domainModelNV);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("/ASS_war_exploded/nhan-vien/index");
    }
}
