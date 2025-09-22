package iuh.fit.tuan02;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebFilter(
        urlPatterns = {"/admin/*", "/user/*", "/login"},
        initParams = {
                @WebInitParam(name = "username", value = "test"),
                @WebInitParam(name = "password", value = "123456")
        }
)
public class AuthenticationFilter implements Filter {
    private String expectedUsername;
    private String expectedPassword;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        expectedUsername = filterConfig.getInitParameter("username");
        expectedPassword = filterConfig.getInitParameter("password");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (expectedUsername.equals(username) && expectedPassword.equals(password)) {
            // Lưu session để xác nhận đã đăng nhập
            HttpSession session = req.getSession(true);
            session.setAttribute("user", username);

            chain.doFilter(request, response); // Cho phép tiếp tục
        } else {
            // Nếu không hợp lệ, trả về thông báo lỗi hoặc chuyển hướng
            res.getWriter().println("<h3>Sign up fail</h3>");
        }
    }

    @Override
    public void destroy() {
        // Clean up nếu cần
    }
}
