package druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws IOException {
        //导入jar包
        //定义配置文件

        //加载配置文件
        InputStream in = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        properties.load(in);

        try {
            // 获取连接池对象
            DataSource ds = DruidDataSourceFactory.createDataSource(properties);
            Connection connection = ds.getConnection();
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
