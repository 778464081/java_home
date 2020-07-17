package cn.edu.ecut.dao;

import cn.edu.ecut.jdbc.DatabaseType;
import cn.edu.ecut.jdbc.JdbcHelper;
import cn.edu.ecut.jdbc.RowMapper;
import cn.edu.ecut.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    JdbcHelper h = JdbcHelper.getInstance(DatabaseType.MYSQL);

    public User loadByUserName(String username){
        String sql = "SELECT * from users where username = ?";
        RowMapper<User> rowMapper = new RowMapper<User>() {
            @Override
            public User wrap(ResultSet rs) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        };
        User user = h.single(sql, rowMapper, username);
        return user;
    }

    public User loadByUserNameAndPassword(User user){
        String sql = "SELECT * from users where username = ? and password = ?";
        RowMapper<User> rowMapper = new RowMapper<User>() {
            @Override
            public User wrap(ResultSet rs) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        };
        User user1 = h.single(sql,rowMapper,user.getUsername(),user.getPassword());
        return  user;
    }
}
