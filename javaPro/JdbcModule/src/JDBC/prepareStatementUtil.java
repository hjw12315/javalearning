package JDBC;

import util.JDBCUtil;

import java.math.BigDecimal;
import java.sql.*;

public class prepareStatementUtil {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "select ename,job_id,salary from emp where dept_id=10";
        try {
            conn = JDBCUtil.connection();
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery(sql);
            StringBuilder stringBuilder = new StringBuilder();
            while (resultSet.next()) {  // 每次移动一行
                String name = resultSet.getString(1);
                int job_id = resultSet.getInt(2);
                BigDecimal salary = resultSet.getBigDecimal("salary");
                stringBuilder.append(name).append(" ").append(job_id)
                        .append(" ").append(salary).append('\n');
            }
            System.out.println(stringBuilder.toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(conn, preparedStatement, resultSet);
        }
    }
}
