package controller;

import Repository.CuaHangRepository;
import domain_model.ChucVu;
import domain_model.CuaHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import view_model.QLCuaHang;


import java.io.IOException;

@WebServlet({
        "/cua-hang/index",    // GET
        "/cua-hang/create",   // GET
        "/cua-hang/edit",     // GET
        "/cua-hang/delete",   // GET
        "/cua-hang/store",    // POST
        "/cua-hang/update",   // POST
})
public class CuaHangServlet extends HttpServlet {
    private CuaHangRepository chRepo;

    public CuaHangServlet(){
        this.chRepo = new CuaHangRepository();
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
        String ma = request.getParameter("ma");
        CuaHang domainModelCH = this.chRepo.findByMa(ma);
        request.setAttribute("ch", domainModelCH);
        request.setAttribute("view", "/view/cua_hang/edit.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        CuaHang domainModelCH = this.chRepo.findByMa(ma);
        this.chRepo.delete(domainModelCH);
        response.sendRedirect("/ASS_war_exploded/cua-hang/index");
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachCH", this.chRepo.findAll());
        request.setAttribute("view", "/view/cua_hang/index.jsp");
        request.getRequestDispatcher("/view/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view", "/view/cua_hang/create.jsp");
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
            response.sendRedirect("/ASS_war_exploded/cua-hang/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String diaChi = request.getParameter("ten");

            HttpSession session = request.getSession();
            if (ma.trim().equals("") || ten.trim().equals("") || diaChi.trim().equals(""))  {
                session.setAttribute("errorMessage2", "Vui Lòng Không Để Trống Thông Tin");
                response.sendRedirect("/ASS_war_exploded/cua-hang/create");
            } else {
                CuaHang domainModelCH = new CuaHang();
                BeanUtils.populate(domainModelCH, request.getParameterMap());
                this.chRepo.insert(domainModelCH);
                response.sendRedirect("/ASS_war_exploded/cua-hang/index");
//
//                if (ma.trim().equals("") || ten.trim().equals("") ) {
//                    session.setAttribute("errorMessage2", "Vui Lòng Không Để Trống Thông Tin");
//                    response.sendRedirect("/ASS_war_exploded/chuc-vu/create");
//                } else {
//                    ChucVu domainModelCV = new ChucVu();
//                    BeanUtils.populate(domainModelCV, request.getParameterMap());
//                    this.cvRepo.insert(domainModelCV);
//                    response.sendRedirect("/ASS_war_exploded/chuc-vu/index");
//                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            CuaHang domainModelCH = this.chRepo.findByMa(ma);
            BeanUtils.populate(domainModelCH, request.getParameterMap());
            this.chRepo.update(domainModelCH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/ASS_war_exploded/cua-hang/index");
    }

}
