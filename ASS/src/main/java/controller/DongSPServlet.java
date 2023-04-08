package controller;

import Repository.DongSPRepository;
import domain_model.DongSp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;




import java.io.IOException;

@WebServlet({
        "/DongSP/index",    // GET
        "/DongSP/create",   // GET
        "/DongSP/edit",     // GET
        "/DongSP/delete",   // GET
        "/DongSP/store",    // POST
        "/DongSP/update",   // POST
})
public class DongSPServlet extends HttpServlet {
    private DongSPRepository dspRepo;
    public DongSPServlet(){

        this.dspRepo = new DongSPRepository();
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
//        request.getRequestDispatcher("/view/DongSP/create.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/DongSP/create.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }
    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachDongSP",this.dspRepo.findAll());
//        request.getRequestDispatcher("/view/DongSP/index.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/DongSP/index.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }

    protected void edit(
//            HttpServletRequest request,
//            HttpServletResponse response
//    ) throws ServletException, IOException {
//        String ma = request.getParameter("ma");
//        QLDongSP kh = this.spRepo.findByMa(ma);
//        request.setAttribute("kh", kh);
////        request.getRequestDispatcher("/view/DongSP/edit.jsp")
////                .forward(request, response);
//        request.setAttribute("view", "/view/DongSP/edit.jsp");
//        request.getRequestDispatcher("/view/layout.jsp")
//                .forward(request, response);
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma  =  request.getParameter("ma");
        DongSp domainModelMS = this.dspRepo.findByMa(ma);
        request.setAttribute("kh", domainModelMS);
        request.setAttribute("view", "/view/mau_sac/edit.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma  =  request.getParameter("ma");
        DongSp domainModelDSP = this.dspRepo.findByMa(ma);
        this.dspRepo.delete(domainModelDSP);
        response.sendRedirect("/ASS_war_exploded/DongSP/index");
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
            response.sendRedirect("/ASS_war_exploded/DongSP/index");
        }

    }
    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
//    ) throws ServletException, IOException {
//        String ma = request.getParameter("ma");
//        String ten = request.getParameter("ten");
//
//
//        QLDongSP vm = new QLDongSP(ma, ten);
//        this.spRepo.insert(vm);
//        response.sendRedirect("/ASS_war_exploded/DongSP/index");
    )throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            HttpSession session = request.getSession();
            if (ma.trim().equals("") || ten.trim().equals("") ) {
                    session.setAttribute("errorMessage2", "Vui Lòng Không Để Trống Thông Tin");
                    response.sendRedirect("/ASS_war_exploded/DongSP/create");
                } else {
                    DongSp domainModelCV = new DongSp();
                    BeanUtils.populate(domainModelCV, request.getParameterMap());
                    this.dspRepo.insert(domainModelCV);
                response.sendRedirect("/ASS_war_exploded/DongSP/index");
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
//            QLDongSP vm = new QLDongSP();
//            BeanUtils.populate(vm, request.getParameterMap());
//            this.spRepo.update(vm);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        response.sendRedirect("/ASS_war_exploded/DongSP/index");
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma  =  request.getParameter("ma");
            DongSp domainModelDSP = this.dspRepo.findByMa(ma);
            BeanUtils.populate(domainModelDSP, request.getParameterMap());
            this.dspRepo.update(domainModelDSP);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("/ASS_war_exploded/DongSP/index");
    }
    }

