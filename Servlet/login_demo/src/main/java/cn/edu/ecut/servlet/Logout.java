package cn.edu.ecut.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/logout")
public class Logout extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Object user = session.getAttribute(UserLogin.lastname + "user");

        System.out.println((String)user);
        session.removeAttribute(UserLogin.lastname + "user");
        session.removeAttribute(UserLogin.lastname + "counter");
        System.out.println("注销成功");
//        session.invalidate();
        resp.sendRedirect("/index.html");
    }
}
