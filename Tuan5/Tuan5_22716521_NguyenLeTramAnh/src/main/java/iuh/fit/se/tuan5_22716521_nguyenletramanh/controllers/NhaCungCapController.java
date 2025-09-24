package iuh.fit.se.tuan5_22716521_nguyenletramanh.controllers;

import iuh.fit.se.tuan5_22716521_nguyenletramanh.daos.NhaCungCapDAO;
import iuh.fit.se.tuan5_22716521_nguyenletramanh.daos.impl.NhaCungCapDAOImpl;
import iuh.fit.se.tuan5_22716521_nguyenletramanh.entities.NhaCungCap;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "nhaCungCapController", value = "/nhacungcap")
public class NhaCungCapController extends HttpServlet {

    @Resource(name = "jdbc/quanlydienthoai")
    private DataSource dataSource;

    private NhaCungCapDAO nhaCungCapDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.nhaCungCapDAO = new NhaCungCapDAOImpl(this.dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSachNhaCungCap", nhaCungCapDAO.findAll());
        req.getRequestDispatcher("/views/nhaCungCap/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
