package JDBC;

import java.math.BigDecimal;
import java.sql.*;

// 查询数据
public class prepareStatementTest {
    public static void main(String[] args){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String JdbcUrl = "jdbc:mysql://127.0.0.1:3306/testdb2";
            String JdbcUser = "root";
            String JdbcPassword = "";
            String sql = "select ename,job_id,salary from emp where dept_id=10";
            try(Connection conn = DriverManager.getConnection(JdbcUrl, JdbcUser, JdbcPassword)){
                try(PreparedStatement ps = conn.prepareStatement(sql)){
                    // 返回一个结果集对象
                    try(ResultSet rs = ps.executeQuery(sql)){  // 执行Statement的方法
                        StringBuilder stringBuilder = new StringBuilder();
                        while(rs.next()){  // 每次移动一行
                            String name = rs.getString(1);
                            int job_id = rs.getInt(2);
                            BigDecimal salary = rs.getBigDecimal("salary");
                            stringBuilder.append(name).append(" ").append(job_id)
                                    .append(" ").append(salary).append('\n');
                        }
                        System.out.println(stringBuilder.toString());
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
