package cn.edu.ecut.servlet;

import cn.edu.ecut.model.User;
import cn.edu.ecut.service.UserServices;
import com.mysql.cj.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/login")
public class UserLogin extends HttpServlet {

    private UserServices userServices = new UserServices() ;
    public static String lastname;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType( "text/html;charset=UTF-8" );

        PrintWriter writer = resp.getWriter();

        HttpSession session = req.getSession();

        String username = req.getParameter("username");
        String password =req.getParameter("password");



        User user = new User();
        user.setPassword(password);
        user.setUsername(username);

        User user1 = userServices.loadByUserNameAndPassword(user);
        int count = 0;

        if (user1.getUsername()!=null){
            session.setAttribute(user1.getUsername()+"user",user1.getUsername());


            Object counter = session.getAttribute(user1.getUsername() + "counter");
            if (counter instanceof Integer){
                count = (int)counter;
                ++count;
            }
            session.setAttribute(user1.getUsername()+"counter",count);

            writer.println("<h1>欢迎你，"+ session.getAttribute(user1.getUsername()+"user")+"</h1>");
            writer.println("<h1>这是你第"+session.getAttribute(user1.getUsername() + "counter")+"</h1>");
            lastname = user1.getUsername();
        }else if (user1.getUsername()==null){
            Object counter = session.getAttribute(lastname + "counter");
            if (counter instanceof Integer){
                count = (int)counter;
                ++count;
            }
            session.setAttribute(lastname+"counter",count);
            writer.println("<h1>欢迎你，"+ session.getAttribute(lastname+"user")+"</h1>");
            writer.println("<h1>这是你第"+session.getAttribute(lastname + "counter")+"</h1>");
        }else{
            writer.println("登录失败");
        }

        writer.println("<a href='/user/logout'>");
        writer.println("注销当前用户");
        writer.println("</a>");
    }
}
