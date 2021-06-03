package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createTableTest {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/testdb2";
            String user = "root";
            String password = "";
            try(Connection connection = DriverManager.getConnection(url, user, password)){
                try(Statement statement = connection.createStatement()){
//                    String sql = "create table user(id int primary key auto_increment, name varchar(20), password varchar(20))";
                    String[] strings = new String[3];
                    strings[0] = "insert into user values(null, '张三', '12345')";
                    strings[1] = "insert into user values(null, '李四', '123abc')";
                    strings[2] = "insert into user values(null, '王五', 'abc123')";
                    int count = 0;
                    while(count<strings.length){
                        statement.executeUpdate(strings[count++]);
                    }

                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
