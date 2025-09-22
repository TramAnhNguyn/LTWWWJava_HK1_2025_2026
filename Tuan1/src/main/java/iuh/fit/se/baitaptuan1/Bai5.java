package iuh.fit.se.baitaptuan1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class Bai5 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set kiểu dữ liệu trả về
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        // Lấy dữ liệu từ form
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Xuất ra trình duyệt
        writer.println("<h2>Result</h2>");
        writer.println("<p>Username: " + username + "</p>");
        writer.println("<p>Password: " + password + "</p>");

        writer.close();
    }
}
