package UploadOrDownload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@WebServlet("/hjg/download")
public class Download extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        File fil = new File("D:/hello.txt");
        String filename = fil.getName();
        resp.setHeader("content-disposition","attachment;filename="+filename);
        InputStream in = new FileInputStream(fil);
        OutputStream out = resp.getOutputStream();

        byte[] bytes = new byte[1024];
        int n;
        while( ( n = in.read( bytes ) ) != -1 ) {
            out.write( bytes , 0 , n );
        }

        out.close();
        in.close();
    }
}
