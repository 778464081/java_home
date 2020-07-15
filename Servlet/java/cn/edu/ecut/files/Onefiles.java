package cn.edu.ecut.files;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Collection;
import java.util.Map;

@WebServlet(urlPatterns = "/request/data/servlet")
@MultipartConfig( location = "D:/Tomcat" )
public class Onefiles extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
//        Part part = req.getPart("upload");
////        if (part!=null)
////        {
////            String filename = part.getSubmittedFileName();
////            part.write(filename);
////        }

//        Collection<Part> parts = req.getParts();
//        if (parts!=null)
//        {
//            for (Part part:parts)
//            {
//                String filenames= part.getSubmittedFileName();
//                part.write(filenames);
//            }
//        }
        Collection<Part> parts = req.getParts();
        if (parts != null && parts.size() > 0) {

            for (Part p : parts) {
                String filename = p.getSubmittedFileName();
                if (filename != null && !filename.trim().isEmpty()) { // 注意 感叹号
                    p.write(filename);
                }
            }

        }
    }

}
