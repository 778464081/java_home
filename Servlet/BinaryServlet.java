package test;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@WebServlet(value = "/c")
@MultipartConfig( location = "uploadfiles" )
public class BinaryServlet extends HttpServlet {
    private static final long serialVersionUID = 1885517496450914452L;

       @Override
        protected void doGet(HttpServletRequest request , HttpServletResponse response )
         throws ServletException, IOException
         {
                throw new IllegalStateException( "不支持GET方式" );
         }
          @Override
          protected void doPost(HttpServletRequest request , HttpServletResponse response )
          throws ServletException, IOException {
              request.setCharacterEncoding("UTF-8");
              response.setCharacterEncoding("UTF-8");
              response.setContentType("txt/html;charset=UTF-8");
              Part part = request.getPart("upfile");
              if (part != null) {
                  // Servlet 3.1 开始可以直接获取用户所上传文件的原始名称
                  String filename = part.getSubmittedFileName();
                  System.out.println(filename);
                  PrintWriter w = response.getWriter();
                  // 如果文件名称不为 null 并且不是空串
                  if (filename != null && !filename.trim().isEmpty()) { // 注意 感叹号

                      part.write(filename); // 将文件内容保存到约定位置

                      w.println("<h1 style='text-align:center;'>");
                      w.println("文件[ " + filename + " ]上传成功");
                      w.println("</h1>");
                      System.out.println("jsafhkjdshfksa");   
                      return;
                  }
                  w.println("<h5 align='center'>上传失败</h5>");
              }
          }
}