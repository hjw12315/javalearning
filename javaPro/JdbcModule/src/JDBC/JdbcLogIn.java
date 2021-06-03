package JDBC;

import java.sql.*;
import java.util.Scanner;

public class JdbcLogIn {

    private String sql;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入账号: ");
        String name = scanner.nextLine();
        System.out.println("请输入密码: ");
        String password = scanner.nextLine();
        JdbcLogIn jl = new JdbcLogIn();
        if(jl.login(name, password))
            System.out.println("登录成功");
        else
            System.out.println("登录失败");

    }

    public boolean login(String name, String password){
        // 输入账号和密码，到数据库中匹配，注册时要确保账号的唯一性
        if(name==null || password==null){
            return false;
        }
//        使用Statement存在sql注入问题，用户恶意输入  用户名随便，密码：a' or 'a'='a
//        sql = "select * from user where name='"+name+"' and password='"+password+"'";
        sql = "select * from user where name=? and password=?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/testdb2";
            String user = "root";
            String passw = "";
            try(Connection connection = DriverManager.getConnection(url, user, passw)){
                try(PreparedStatement statement = connection.prepareStatement(sql)){
                    statement.setString(1, name);
                    statement.setString(2, password);
                    try(ResultSet resultSet = statement.executeQuery()){  // 这里不能使用带参数的
                        return resultSet.next();
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
