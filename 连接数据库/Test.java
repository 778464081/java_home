import com.mysql.cj.xdevapi.Collection;

import java.sql.*;

public class Test {

    public static void main(String[] args) {
        try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tas?serverTimezone=UTC", "root", "root");
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE  student set Name='mjn' where Number=1");
        ResultSet resultSet = statement.executeQuery("select * from student");
            while(resultSet.next()) {
            System.out.println(resultSet.getInt("Number"));
            System.out.println(resultSet.getString("Name"));
        }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

