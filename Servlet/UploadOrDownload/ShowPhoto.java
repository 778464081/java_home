package UploadOrDownload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;

@WebServlet("/hjg/show")
public class ShowPhoto extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setContentType("image/png");

        File file = new File("D:/tomcat.png");
//        OutputStream out = resp.getOutputStream();
//        Files.copy(file.toPath(),out);
        InputStream in = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        OutputStream out = resp.getOutputStream();
        while((in.read(bytes))!=-1){
            out.write(bytes);
        }
        out.close();
        in.close();
    }

}
