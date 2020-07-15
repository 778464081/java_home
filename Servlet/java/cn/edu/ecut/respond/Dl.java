package cn.edu.ecut.respond;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet( "/download/image" )
public class Dl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        File fod = new File("D:/Tomcat/tomcat.png");
        if (fod.exists() && fod.isFile()) {
            // 获取服务器上的原始文件名称
            String name = fod.getName();
            // 获取用于读取文件中数据的字节输入流
            InputStream in = new FileInputStream(fod);

            // 设置将来向HTTP客户端发送响应时响应数据的MIME类型
            response.setContentType("image/png");
            response.setHeader("content-disposition", "attachment;filename=" + name);
            OutputStream out = response.getOutputStream();

            // 声明用来缓存从字节输入流中所读取到的有效字节的数组
            final byte[] bytes = new byte[1024];
            int n; // 用来统计从字节输入流中读取到的有效字节数的变量

            // 从字节输入流中读取字节到数组中并统计实际读取到的字节数
            while ((n = in.read(bytes)) != -1) {
                // 将读取到的有效字节写入到字节输出流中
                out.write(bytes, 0, n);
            }

            // 关闭流
            out.close();
            in.close();

        }
    }}
