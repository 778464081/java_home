package PhotoHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet( "/c" )
public class Captcha extends HttpServlet {
    private static final long serialVersionUID = 2579498403107735984L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置MIME类型
         resp.setContentType( "image/jpeg" );
         // 获取字节输出流
         OutputStream output = resp.getOutputStream();
         // 使用工具类产生图片验证码
         String code = GraphicHelper.create( 4 , true , 180 , 50 , output, 50 );

         // 输出验证码图片上的字符串
         System.out.println( "图片内容: " + code );
    }
}
