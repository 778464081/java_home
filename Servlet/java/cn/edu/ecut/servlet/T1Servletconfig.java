package cn.edu.ecut.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
@WebServlet(urlPatterns = {"/t1","/t1/t1"},
        initParams = {@WebInitParam(name ="姓名",value = "洪建国"),
        @WebInitParam(name="学号",value = "201720180305")
        }
)
public class T1Servletconfig implements Servlet {

    private  ServletConfig sc;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.sc = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
       return this.sc;
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        Enumeration<String> initParamNames = sc.getInitParameterNames(); // 获取所有的初始化参数名称组成的Enumeration对象
        while (initParamNames.hasMoreElements()){
            String name = initParamNames.nextElement();
            String value = sc.getInitParameter(name);
            out.println("name=");
            out.print(name);
            out.println("value=");
            out.print(value);
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
