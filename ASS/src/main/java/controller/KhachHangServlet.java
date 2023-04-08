package controller;

import domain_model.KhachHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import Repository.KhachHangRepository;
import view_model.QLKhachHang;

import java.io.IOException;
import java.util.ArrayList;



    @WebServlet({
            "/khach-hang/index",    // GET
            "/khach-hang/create",   // GET
            "/khach-hang/edit",     // GET
            "/khach-hang/delete",   // GET
            "/khach-hang/store",    // POST
            "/khach-hang/update",   // POST
    })
    public class KhachHangServlet extends HttpServlet {
        private KhachHangRepository khRepo;

        public KhachHangServlet()
        {
            this.khRepo = new KhachHangRepository();
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
            KhachHang domainModelKH = this.khRepo.findByMa(ma);
            request.setAttribute("kh", domainModelKH);
            request.setAttribute("view", "/view/khach_hang/edit.jsp");
            request.getRequestDispatcher("/view/layout.jsp")
                    .forward(request, response);
        }

        protected void delete(
                HttpServletRequest request,
                HttpServletResponse response
        ) throws ServletException, IOException {
            String ma = request.getParameter("ma");
            KhachHang domainModelKH = this.khRepo.findByMa(ma);
            this.khRepo.delete(domainModelKH);
            response.sendRedirect("/ASS_war_exploded/khach-hang/index");
        }

        protected void index(
                HttpServletRequest request,
                HttpServletResponse response
        ) throws ServletException, IOException {
            request.setAttribute("danhSachKH", this.khRepo.findAll());
            request.setAttribute("view", "/view/khach_hang/index.jsp");
            request.getRequestDispatcher("/view/layout.jsp")
                    .forward(request, response);
        }

        protected void create(
                HttpServletRequest request,
                HttpServletResponse response
        ) throws ServletException, IOException {
            request.setAttribute("view", "/view/khach_hang/create.jsp");
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
                response.sendRedirect("/ASS_war_exploded/khach-hang/index");
            }
        }

        protected void store(
                HttpServletRequest request,
                HttpServletResponse response
        ) throws ServletException, IOException {
            try {
                KhachHang domainModelKH = new KhachHang();
                BeanUtils.populate(domainModelKH, request.getParameterMap());
                this.khRepo.insert(domainModelKH);
            } catch (Exception e) {
                e.printStackTrace();
            }

            response.sendRedirect("/ASS_war_exploded/khach-hang/index");
        }

        protected void update(
                HttpServletRequest request,
                HttpServletResponse response
        ) throws ServletException, IOException {
            try {
                String ma = request.getParameter("ma");
                KhachHang domainModelKH = this.khRepo.findByMa(ma);
                BeanUtils.populate(domainModelKH, request.getParameterMap());
                this.khRepo.update(domainModelKH);
            } catch (Exception e) {
                e.printStackTrace();
            }

            response.sendRedirect("/ASS_war_exploded/khach-hang/index");
        }
}
