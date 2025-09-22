package iuh.fit.se.baitaptuan1;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "user-param",
        urlPatterns = {"/user-param", "/param"},
        initParams ={
            @WebInitParam(name = "username", value="user1007"),
                @WebInitParam(name = "password", value = "1234567")

})
public class Bai4 extends HttpServlet {

    private String username;
    private String password;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        username = config.getInitParameter("username");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1 style='color: red'>" + username + "</h1>");
        out.println("<h1 style='color: green'>" + this.getServletConfig().getInitParameter("password") + "</h1>");
        out.println("</body></html>");

    }

    public void destroy(){}
}
