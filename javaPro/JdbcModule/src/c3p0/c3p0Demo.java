package c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class c3p0Demo {
    // 使用c3p0-config.xml中的默认配置
    public static void defaultConfig(){
        // 导入c3p0的两个jar包：c3p0-0.9.5.2.jar、mchange-commons-java-0.2.12.jar 和数据库驱动的jar包
        // 定义配置文件：c3p0.properties 或者 c3p0-config.xml
        // 创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();
        try {
            for(int i=0; i<11; i++){
                Connection connection = ds.getConnection();  // 创建连接
                System.out.println(i+1+": "+connection);
                if(i==5)
                    connection.close();  // 归还连接
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // 使用c3p0-config.xml中的其他配置，可以更改为不同的数据库
    public static void namedConfig(){
        DataSource ds = new ComboPooledDataSource("otherc3p0");
        try {
            for(int i=0; i<8; i++){
                Connection connection = ds.getConnection();
                System.out.println(i+1+": "+connection);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) {
        defaultConfig();
        namedConfig();
    }
}
