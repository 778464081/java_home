package UploadOrDownload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Collection;

@WebServlet("/hjg/upload")
@MultipartConfig(location = "D:/Tomcat")
public class Upload extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter w = resp.getWriter();

        //第一种方法
        Part part = req.getPart("upload");
        String filename =part.getSubmittedFileName();
//        part.write("filename");

        //第二种方法

        //创建要保存的路径
        Path path = Path.of("D:/Tomcat/test",filename);
        Collection<String> headerNames = part.getHeaderNames();
        System.out.println("casdcscsdcsd");
        System.out.println(headerNames);
        System.out.println( part.getContentType());

        InputStream in = part.getInputStream();
        Files.copy(in,path, StandardCopyOption.REPLACE_EXISTING);
        w.println("<h1>上传成功！！！！！</h1>");


    }
}
