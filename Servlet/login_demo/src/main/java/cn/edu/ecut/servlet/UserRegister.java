package cn.edu.ecut.servlet;

import cn.edu.ecut.dao.UserDao;
import cn.edu.ecut.jdbc.DatabaseType;
import cn.edu.ecut.jdbc.JdbcHelper;
import cn.edu.ecut.model.User;
import cn.edu.ecut.service.UserServices;
import cn.edu.ecut.util.Const;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/user/register")
public class UserRegister extends HttpServlet {
    private UserServices userServices = new UserServices() ;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType( "text/html;charset=UTF-8" );
        PrintWriter writer = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        User user = userServices.loadByUserName(username);
        if (Objects.isNull(user)){
            if (password.length()> Const.PASSWORD_LENGTH){
                if (password.equals(confirmPassword)){
                    writer.println("注册成功");
                }else{
                    writer.println("密码不一致");
                }
            }else {
                writer.println("密码长度必须大于6");
            }
        }else{
            writer.println("注册的用户已存在");
        }

        JdbcHelper h = JdbcHelper.getInstance(DatabaseType.MYSQL);
        String sql = "INSERT INTO users(username,password) values(?,?)";
        h.update(sql,username,password);
        h.release();
    }

}
