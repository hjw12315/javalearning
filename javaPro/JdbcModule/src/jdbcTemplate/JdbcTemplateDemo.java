package jdbcTemplate;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

public class JdbcTemplateDemo {
    public static void main(String[] args) throws IOException {
        // spring框架对jdbc的简单封装,提供一个JdbcTemplate对象
        // 导入jar包
        // 创建jdbcTemplate对象
        Properties properties = new Properties();
        properties.load(JdbcTemplateDemo.class.getClassLoader()
                .getResourceAsStream("druid.properties"));
        DataSource dataSource = null;
        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JdbcTemplate template = new JdbcTemplate(dataSource);
//        JdbcTemplate template = new JdbcTemplate(new ComboPooledDataSource());
        // 定义sql语句
        String sql1 = "update account set balance=? where name=?";
        int count = template.update(sql1, 2000, "王五");
        System.out.println(count);
    }
}

/**
 * JdbcTemplate对象的方法：
 *  update();执行增删改任务
 *  queryForMap(); 查询结果并将结果集封装为Map对象
 *  queryForList();
 *  query(); 将结果封装为JavaBean对象
 *  queryForObject(); 将结果封装为对象
 *
 */
