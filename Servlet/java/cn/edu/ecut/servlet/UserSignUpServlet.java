package cn.edu.ecut.servlet;



import cn.edu.ecut.jdbc.DatabaseType;
import cn.edu.ecut.jdbc.JdbcHelper;
import cn.edu.ecut.jdbc.RowMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet ;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet( "/user/sign/up" )
public class UserSignUpServlet extends HttpServlet {

    @Override
    protected void service( HttpServletRequest request , HttpServletResponse response )
            throws ServletException, IOException {
        request.setCharacterEncoding( "UTF-8" );
        response.setCharacterEncoding( "UTF-8" );

        response.setContentType( "text/html;charset=UTF-8" );
        PrintWriter out = response.getWriter();

        String name = request.getParameter( "name" );
        System.out.println( "name : " + name );
        String gender = request.getParameter( "gender" );
        System.out.println( "gender : " + gender );
        String birthdate = request.getParameter( "birthdate" );
        System.out.println( "birthdate : " + birthdate );

        JdbcHelper h = JdbcHelper.getInstance( DatabaseType.MYSQL );

        String sql = "SELECT ifnull( max(id) , 0 ) + 1 FROM t_students " ; // MySQL
        RowMapper<Integer> idRowMapper = new RowMapper<Integer>() {
            @Override
            public Integer wrap(ResultSet rs) throws SQLException {
                return rs.getInt( 1 );
            }
        };
        Integer id = h.single( sql , idRowMapper ); // 执行查询操作并返回一个 id

        sql = "INSERT INTO t_students( name , gender , birthdate , id ) VALUES ( ? , ? , ? , ? )" ;
        // 根据 字符串  birthdate 的值 创建一个表示该日期的 java.sql.Date 类型的对象
        int count = h.update( sql , name , gender , birthdate , id );
        if( count > 0 ) {
            out.println( "<h2>" );
            out.println( "保存成功" );
            out.println( "</h2>" );
            out.println( "<a href='/index.html'>继续添加</a>" );
            out.println( " | " );
            out.println( "<a href='/user/list'>查看用户列表</a>" );
        }

        h.release();
    }
}
