package fit.iuh.tuan2bai2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.*;

@WebServlet("/upload")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,  // 1MB
        maxFileSize = 1024 * 1024 * 10,       // 10MB
        maxRequestSize = 1024 * 1024 * 50     // 50MB
)
public class UploadServlet extends HttpServlet {

    private static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Thư mục thực lưu file
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();


        // Lấy danh sách file gửi lên
        for (Part part : request.getParts()) {
            String fileName = getFileName(part);
            if (fileName != null && !fileName.isEmpty()) {
                part.write(uploadPath + File.separator + fileName);
            }
        }

        response.getWriter().println("<h3> Upload successfully !</h3>");
    }

    // Trích xuất tên file từ header
    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return null;
    }
}
