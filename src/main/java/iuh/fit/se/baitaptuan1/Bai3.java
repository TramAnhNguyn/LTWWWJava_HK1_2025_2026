package iuh.fit.se.baitaptuan1;

import iuh.fit.se.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@WebServlet(name = "user", value = "/user-json")
public class Bai3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //create new user
        User user = new User("Nguyen Le Tram Anh", 21);
        // Set kiểu dữ liệu trả về là JSON
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // Sử dụng ObjectMapper để chuyển object thành JSON string
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);

        // Ghi JSON ra response
        resp.getWriter().write(json);
    }
}
