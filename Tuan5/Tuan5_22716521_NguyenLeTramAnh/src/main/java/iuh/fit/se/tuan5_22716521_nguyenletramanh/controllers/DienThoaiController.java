package iuh.fit.se.tuan5_22716521_nguyenletramanh.controllers;

import iuh.fit.se.tuan5_22716521_nguyenletramanh.daos.DienThoaiDAO;
import iuh.fit.se.tuan5_22716521_nguyenletramanh.daos.impl.DienThoaiDAOImpl;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "dienThoaiController", value = "/dienthoai")
public class DienThoaiController extends HttpServlet {

    @Resource(name = "jdbc/quanlydienthoai")
    private DataSource dataSource;

    private DienThoaiDAO dienThoaiDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.dienThoaiDAO = new DienThoaiDAOImpl(this.dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSachDienThoai", dienThoaiDAO.findAll());
        req.getRequestDispatcher("/views/dienThoai/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
