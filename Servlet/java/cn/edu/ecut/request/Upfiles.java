package cn.edu.ecut.request;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
@MultipartConfig
public class Upfiles extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part =req.getPart("upload");
        String filename = part.getSubmittedFileName();
        ServletContext sc = req.getServletContext();
        String load = sc.getInitParameter("store");
        Path path = Path.of(load,filename);
        InputStream in = part.getInputStream();
        Files.copy( in , path, StandardCopyOption.REPLACE_EXISTING );


        //通过状态代码命令浏览器重新打开另一个资源
        resp.setStatus(302);
        resp.setHeader("location","/image/show");
        System.out.println("csdcasd");

        //nio

//        ServletContext sc = req.getServletContext();
//        // String realPath = request.getRealPath( "/uploads" );
//        String realPath = sc.getRealPath( "/upload" );
//        System.out.println( "path : " + realPath );
//
//        Part part = req.getPart( "upload" );
//        System.out.println( "part : " + part );
//
//        String filename = part.getSubmittedFileName();
//        System.out.println( "filename : " + filename );



    }
}
