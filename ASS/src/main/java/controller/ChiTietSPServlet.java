package controller;

import Repository.*;
import domain_model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.List;

@WebServlet({
        "/chi-tiet-sp/index",    // GET
        "/chi-tiet-sp/create",   // GET
        "/chi-tiet-sp/edit",     // GET
        "/chi-tiet-sp/delete",   // GET
        "/chi-tiet-sp/store",    // POST
        "/chi-tiet-sp/update",   // POST
})
public class ChiTietSPServlet extends HttpServlet {
    private ChiTietSpRepository chiTietSPRepo;

    private SanPhamRepository spRepo;
    private NsxRepository nsxRepo;
    private MauSacRepository msRepo;
    private DongSPRepository dongSPRepo;

    public ChiTietSPServlet() {

        this.chiTietSPRepo = new ChiTietSpRepository();
        this.spRepo = new SanPhamRepository();
        this.nsxRepo = new NsxRepository();
        this.msRepo = new MauSacRepository();
        this.dongSPRepo = new DongSPRepository();
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

        request.setAttribute("ctsp", this.chiTietSPRepo.findAll());
        request.setAttribute("dongsp", this.dongSPRepo.findAll());
        request.setAttribute("ms", this.msRepo.findAll());
        request.setAttribute("sp", this.spRepo.findAll());
        request.setAttribute("nsx", this.nsxRepo.findAll());
        request.setAttribute("view", "/view/chi_tiet_sp/edit.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChiTietSp domainModelCT = this.chiTietSPRepo.findById(id);
        this.chiTietSPRepo.delete(domainModelCT);
        response.sendRedirect("/ASS_war_exploded/chi-tiet-sp/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachchiTietSP", this.chiTietSPRepo.findAll());
//        request.getRequestDispatcher("/view/chi_tiet_sp/index.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/chi_tiet_sp/index.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
//        request.getRequestDispatcher("/view/chi_tiet_sp/create.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/chi_tiet_sp/create.jsp");
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
            response.sendRedirect("/ASS_war_exploded/chi-tiet-sp/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            ChiTietSp domainModelCT = new ChiTietSp();
            BeanUtils.populate(domainModelCT, request.getParameterMap());
            this.chiTietSPRepo.insert(domainModelCT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("/ASS_war_exploded/chi-tiet-sp/index");

    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            ChiTietSp domainModelCT = this.chiTietSPRepo.findById(id);
            BeanUtils.populate(domainModelCT, request.getParameterMap());
            this.chiTietSPRepo.update(domainModelCT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("/ASS_war_exploded/chi-tiet-sp/index");
    }
}

