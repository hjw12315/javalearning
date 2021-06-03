package JDBC;

import java.sql.*;

public class RollbackTest {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/testdb";
            String name = "root";
            String passd = "";
            try(Connection connection = DriverManager.getConnection(url, name, passd)) {
                connection.setAutoCommit(false);   // 开启事务
                String sql1 = "update account set balance = balance + ? where name = ?";
                String sql2 = "update account set balance = balance - ? where name = ?";
                try (PreparedStatement statement1 = connection.prepareStatement(sql1);
                     PreparedStatement statement2 = connection.prepareStatement(sql2)) {
                    statement1.setDouble(1, 500);
                    statement1.setString(2, "张三");
                    statement2.setDouble(1, 500);
                    statement2.setString(2, "李四");

                    statement1.executeUpdate();
//                    int a = 3/0;
                    statement2.executeUpdate();
                } catch (Exception e) {
                    System.out.println("roll back");
                    connection.rollback();    // 回滚
                    connection.setAutoCommit(true);
                    throw e;
                }
                connection.commit();   // 提交事务
                connection.setAutoCommit(true);
            }catch(SQLException e){
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
