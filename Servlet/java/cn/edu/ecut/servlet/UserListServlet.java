package cn.edu.ecut.servlet;

import cn.edu.ecut.entity.User;
import cn.edu.ecut.jdbc.DatabaseType;
import cn.edu.ecut.jdbc.JdbcHelper;
import cn.edu.ecut.jdbc.RowMapper;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet( "/user/list" )
public class UserListServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request , HttpServletResponse response )
            throws ServletException, IOException {
        request.setCharacterEncoding( "UTF-8" );
        response.setCharacterEncoding( "UTF-8" );

        response.setContentType( "text/html;charset=UTF-8" );
        PrintWriter out = response.getWriter();

        JdbcHelper h = JdbcHelper.getInstance( DatabaseType.MYSQL );

        String sql = "SELECT id , name , gender , birthdate FROM t_students ORDER BY id ASC" ; // MySQL
        RowMapper<User> rowMapper = new RowMapper<>() {
            @Override
            public User wrap(ResultSet rs) throws SQLException {
                User user = new User();
                user.setId( rs.getInt( "id" ) );
                user.setName( rs.getString( "name" ) );
                user.setGender( rs.getString( "gender" ) );
                java.sql.Date date = rs.getDate( "birthdate" );
                user.setBirthdate( date != null ? date.toLocalDate() : null );
                return user ;
            }
        };

        List<User> list = h.list( sql , rowMapper );

        for( User u : list ) {
            out.println( "<div style='line-height:50px;'>" + u + "</div>" );
        }

        h.release();
    }

}
