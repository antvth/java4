package controller;

import Repository.NsxRepository;
import domain_model.MauSac;
import domain_model.Nsx;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;


import java.io.IOException;

@WebServlet({
        "/Nsx/index",    // GET
        "/Nsx/create",   // GET
        "/Nsx/edit",     // GET
        "/Nsx/delete",   // GET
        "/Nsx/store",    // POST
        "/Nsx/update",   // POST
})
public class NsxServlet extends HttpServlet {
    private NsxRepository nsxRepo;
    public NsxServlet(){

        this.nsxRepo = new NsxRepository();
    }
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
//        request.getRequestDispatcher("/view/Nsx/create.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/Nsx/create.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }
    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachNsx",this.nsxRepo.findAll());
//        request.getRequestDispatcher("/view/Nsx/index.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/Nsx/index.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);

    }
    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma  =  request.getParameter("ma");
        Nsx domainModelNSX = this.nsxRepo.findByMa(ma);
        request.setAttribute("kh", domainModelNSX);
        request.setAttribute("view", "/view/Nsx/edit.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma  =  request.getParameter("ma");
        Nsx domainModelNSX = this.nsxRepo.findByMa(ma);
        this.nsxRepo.delete(domainModelNSX);
        response.sendRedirect("/ASS_war_exploded/Nsx/index");
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
            response.sendRedirect("/ASS_war_exploded/Nsx/index");
        }

    }
    protected void store(
//            HttpServletRequest request,
//            HttpServletResponse response
//    ) throws ServletException, IOException {
//        String ma = request.getParameter("ma");
//        String ten = request.getParameter("ten");
//
//
//        QLNsx vm = new QLNsx(ma, ten);
//        this.spRepo.insert(vm);
//        response.sendRedirect("/ASS_war_exploded/Nsx/index");
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {

            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            HttpSession session = request.getSession();
            if (ma.trim().equals("") || ten.trim().equals("") ) {
                session.setAttribute("errorMessage2", "Vui Lòng Không Để Trống Thông Tin");
                response.sendRedirect("/ASS_war_exploded/Nsx/create");
            } else {
                Nsx domainModelCV = new Nsx();
                BeanUtils.populate(domainModelCV, request.getParameterMap());
                this.nsxRepo.insert(domainModelCV);
                response.sendRedirect("/ASS_war_exploded/Nsx/index");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
    protected void update(
//            HttpServletRequest request,
//            HttpServletResponse response
//    ) throws ServletException, IOException {
//        try {
//            QLNsx vm = new QLNsx();
//            BeanUtils.populate(vm, request.getParameterMap());
//            this.spRepo.update(vm);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        response.sendRedirect("/ASS_war_exploded/Nsx/index");
//    }


            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma  =  request.getParameter("ma");
            Nsx domainModelNSX = this.nsxRepo.findByMa(ma);
            BeanUtils.populate(domainModelNSX, request.getParameterMap());
            this.nsxRepo.update(domainModelNSX);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("/ASS_war_exploded/Nsx/index");
    }
}
