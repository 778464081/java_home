package test;

import java.io.BufferedReader;
import java.io.IOException;
 import java.io.PrintWriter;
import java.util.Enumeration;

 import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/parse/request")
public class ParseRequestServlet extends HttpServlet {
    private static final long serialVersionUID = 4275194727530458199L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String method = request.getMethod(); // 请求方法
        StringBuffer buffer = request.getRequestURL(); // 被请求资源的路径
        String queryString = request.getQueryString(); // 获取 QueryString
        if (queryString != null) { // 如果 QueryString 不为 null
            buffer.append("?");
            buffer.append(queryString); // 将 QueryString 追加到 request-URL 尾部
        }
        String url = buffer.toString();
        String protocol = request.getProtocol(); // 协议

        System.out.println("- - - 请求行 - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println(method + "\t" + url + "\t" + protocol);

        System.out.println("- - - 请求头 - - - - - - - - - - - - - - - - - - - - - - - -");
        // 获得所有请求报头名称
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement(); // 获取请求头的名称
            String value = request.getHeader(name); // 根据请求头的名称获取其取值
            System.out.println(name + " : " + value); // 在控制台输出报头名称和取值
        }

        System.out.println("- - - 请求体 - - - - - - - - - - - - - - - - - - - - - - - -");
        BufferedReader br = request.getReader(); // 获取读取请求正文数据的字符输入流
        String s = null;
        while ((s = br.readLine()) != null) { // 每次从请求正文中读取一行数据

            System.out.println(s); // 在控制台输出读取到的数据
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter w = response.getWriter();

        w.println("<h3 style='text-align:center;'>ParseRequestServlet</h3>");

    }
}