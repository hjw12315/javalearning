package JDBC;/*
1、导入驱动jar包
2、注册驱动
3、获取数据库连接对象，Connection
4、定义sql
5、获取执行sql语句的对象，Statement
6、执行sql，获取返回结果
7、处理结果
8、释放资源
* */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo1 {
    public static void main(String[] args) {
        // 1.导入jar包 创建libs文件夹，放入相关jar包，Add as library
        try{
            // 2.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            String JdbcUrl = "jdbc:mysql://127.0.0.1:3306/testdb";
            String JdbcUser = "root";
            String JdbcPassword = "";
            // 3.定义sql语句
            String sql1 = "insert into account values(null, '王五', 2000)";
            String sql2 = "update account set balance=1000 where name='王五'";
            String sql3 = "delete from account where name='王五'";
//            String sql4 = "create table executeUpdate(id int, name varchar(20))";
            // 4.获取连接对象
            try(Connection conn = DriverManager.getConnection(JdbcUrl, JdbcUser, JdbcPassword)){
                // 5.获取执行sql语句的对象
                try(Statement statement = conn.createStatement()){
                    // 6.执行sql语句
                    int result= statement.executeUpdate(sql1);
                    if(result==1){
                        System.out.println("执行成功");
                    }else{
                        System.out.println("执行失败");
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

/*
*
*DriverManager:
*   1、注册驱动
*   2、获取数据库连接对象Connection
*Connection:
*   1、获取执行sql语句的对象：
*       1、Statement   connection.createStatement()
*       2、PrepareStatement   connection.PrepareStatement(String sql)
*   2、事务管理
*       1、setAutoCommit(boolean auto)  开启自动提交事务
*       2、commit()    提交事务
*       3、rollback()  回滚
* Statement:
*   1、boolean statement.execute(String sql) 可执行任何语句
*   2、int statement.executeUpdate(String sql)  执行增删改(insert,update,delete)语句或者与数据库和表有关的语句
*   3、ResultSet statement.executeQuery(String sql)  执行查找语句
*
* */
