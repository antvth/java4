package controller;



import Repository.MauSacRepository;
import domain_model.DongSp;
import domain_model.MauSac;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;



import java.io.IOException;
import java.util.ArrayList;
@WebServlet({
        "/mau-sac/index",    // GET
        "/mau-sac/create",   // GET
        "/mau-sac/edit",     // GET
        "/mau-sac/delete",   // GET
        "/mau-sac/store",    // POST
        "/mau-sac/update",   // POST
})
public class MauSacServlet extends HttpServlet {
    private MauSacRepository msRepo;
    public MauSacServlet(){
        this.msRepo = new MauSacRepository();
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
//        request.getRequestDispatcher("/view/mau_sac/create.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/mau_sac/create.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }
    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachMS",this.msRepo.findAll());
//        request.getRequestDispatcher("/view/mau_sac/index.jsp")
//                .forward(request, response);
        request.setAttribute("view", "/view/mau_sac/index.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }
    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma  =  request.getParameter("ma");
        MauSac domainModelMS = this.msRepo.findByMa(ma);
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
        MauSac domainModelMS = this.msRepo.findByMa(ma);
        this.msRepo.delete(domainModelMS);
        response.sendRedirect("/ASS_war_exploded/mau-sac/index");
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
            response.sendRedirect("/ASS_war_exploded/mau-sac/index");
        }

    }
    protected void store(
//            HttpServletRequest request,
//            HttpServletResponse response
//    ) throws ServletException, IOException {
//        String ma = request.getParameter("ma");
//        String ten = request.getParameter("ten");
//
//        QLMauSac vm = new QLMauSac(ma, ten);
//        this.spRepo.insert(vm);
//        response.sendRedirect("/ASS_war_exploded/mau-sac/index");

            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {

            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            HttpSession session = request.getSession();
            if (ma.trim().equals("") || ten.trim().equals("") ) {
                session.setAttribute("errorMessage2", "Vui Lòng Không Để Trống Thông Tin");
                response.sendRedirect("/ASS_war_exploded/mau-sac/create");
            } else {
                MauSac domainModelCV = new MauSac();
                BeanUtils.populate(domainModelCV, request.getParameterMap());
                this.msRepo.insert(domainModelCV);
                response.sendRedirect("/ASS_war_exploded/mau-sac/index");
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
//            QLMauSac vm = new QLMauSac();
//            BeanUtils.populate(vm, request.getParameterMap());
//            this.spRepo.update(vm);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        response.sendRedirect("/ASS_war_exploded/mau-sac/index");
//    }
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma  =  request.getParameter("ma");
            MauSac domainModelMS = this.msRepo.findByMa(ma);
            BeanUtils.populate(domainModelMS, request.getParameterMap());
            this.msRepo.update(domainModelMS);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("/ASS_war_exploded/mau-sac/index");
    }
}
