package util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static{
        try {
            Properties pp = new Properties();
//            pp.load(new FileReader("C:\\Users\\hul\\Desktop\\javademo\\javaPro\\JdbcModule\\src\\jdbc.properties"));
            // 通过类加载器来获得文件路径
            ClassLoader classLoader = JDBCUtil.class.getClassLoader();
            URL resource = classLoader.getResource("jdbc.properties");
            String path = resource.getPath();
            pp.load(new FileReader(path));
            url = pp.getProperty("url");
            user = pp.getProperty("user");
            password = pp.getProperty("password");
            driver = pp.getProperty("driver");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库的连接
     * @return
     * @throws SQLException
     */
    public static Connection connection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 关闭资源
     * @param connection
     * @param statement
     */
    public static void close(Connection connection, Statement statement){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 关闭资源
     * @param connection
     * @param statement
     * @param rs
     */
    public static void close(Connection connection, Statement statement, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        close(connection, statement);
    }
}
