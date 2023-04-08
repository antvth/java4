package controller;

import Repository.ChucVuRepository;
import domain_model.ChucVu;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import view_model.QLChucVu;


import java.io.IOException;

@WebServlet({
        "/chuc-vu/index",    // GET
        "/chuc-vu/create",   // GET
        "/chuc-vu/edit",     // GET
        "/chuc-vu/delete",   // GET
        "/chuc-vu/store",    // POST
        "/chuc-vu/update",   // POST
})
public class ChucVuServlet extends HttpServlet {
    private ChucVuRepository cvRepo;
    public ChucVuServlet(){ this.cvRepo = new ChucVuRepository(); }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
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
    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view", "/view/chuc_vu/create.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }
    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachSP",this.cvRepo.findAll());
        request.setAttribute("view", "/view/chuc_vu/index.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }
    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
//        Integer id = request.getParameter("id");
//        ChucVu domainModelKH = this.cvRepo.findByMa(id);
        String ma = request.getParameter("ma");
        ChucVu domainModelKH = this.cvRepo.findByMa(ma);
        request.setAttribute("kh", domainModelKH);
        request.setAttribute("view", "/view/chuc_vu/edit.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
//            HttpServletRequest request,
//            HttpServletResponse response
//    ) throws ServletException, IOException {
//        String ma = request.getParameter("ma");
//        ChucVu domainModelKH = this.cvRepo.findByMa(ma);
//        request.setAttribute("kh", domainModelKH);
//        request.getRequestDispatcher("/view/chuc_vu/edit.jsp")
//                .forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
//        String ma = request.getParameter("ma");
//        ChucVu domainModelCV = this.cvRepo.findByMa(ma);
        String ma = request.getParameter("ma");
        ChucVu domainModelCV = this.cvRepo.findByMa(ma);
        this.cvRepo.delete(domainModelCV);
        response.sendRedirect("/ASS_war_exploded/chuc-vu/index");
    }
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            response.sendRedirect("/ASS_war_exploded/chuc-vu/index");
        }

    }
    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            HttpSession session = request.getSession();
            if (ma.trim().equals("") || ten.trim().equals("") ) {
                session.setAttribute("errorMessage2", "Vui Lòng Không Để Trống Thông Tin");
                response.sendRedirect("/ASS_war_exploded/chuc-vu/create");
            } else {
                ChucVu domainModelCV = new ChucVu();
                BeanUtils.populate(domainModelCV, request.getParameterMap());
                this.cvRepo.insert(domainModelCV);
                response.sendRedirect("/ASS_war_exploded/chuc-vu/index");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

//        HttpServletRequest request,
//        HttpServletResponse response
//        ) throws ServletException, IOException {
//            try {
//                KhachHang domainModelKH = new KhachHang();
//                BeanUtils.populate(domainModelKH, request.getParameterMap());
//                this.khRepo.insert(domainModelKH);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            response.sendRedirect("/ASS_war_exploded/khach-hang/index");
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
//            String ma = request.getParameter("ma");
//            ChucVu domainModelCV = this.cvRepo.findByMa(ma);
            String ma = request.getParameter("ma");
            ChucVu domainModelCV = this.cvRepo.findByMa(ma);
            BeanUtils.populate(domainModelCV, request.getParameterMap());
            this.cvRepo.update(domainModelCV);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/ASS_war_exploded/chuc-vu/index");
    }
}
