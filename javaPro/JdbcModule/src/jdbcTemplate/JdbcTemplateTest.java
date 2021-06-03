package jdbcTemplate;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.DruidUtil;

import java.util.List;
import java.util.Map;

public class JdbcTemplateTest {
    private JdbcTemplate template = new JdbcTemplate(DruidUtil.getDataSource());
    @Test
    public void testInsert(){
        String sql = "insert into emp(id, ename, salary, dept_id) values(?,?,?,?)";
        int count = template.update(sql, null, "王五", 10000, 10);
        System.out.println(count);
    }
    @Test
    public void testUpdate(){
        String sql = "update emp set salary=? where ename=?";
        System.out.println(template.update(sql, 15000, "王五"));
    }
    @Test
    public void testDelete(){
        String sql = "delete from emp where ename=?";
        System.out.println(template.update(sql, "王五"));
    }

    /**
     * 结果集只能是一行，将列名做为key，数据做为value
     */
    @Test
    public void testQueryForMap(){
        String sql = "select * from emp where id=?";
        Map<String, Object> map = template.queryForMap(sql,1001);
        System.out.println(map);  // {id=1001, ename=孙悟空, job_id=4, mgr=1004, joindate=2000-12-17, salary=8000.00, bonus=null, dept_id=20}
    }

    /**
     * 将每一行封装到Map,再封装到List
     */
    @Test
    public void testQueryForList(){
        String sql = "select * from emp";
        List<Map<String, Object>> list = template.queryForList(sql);
        System.out.println(list);
    }

    /**
     * 将每一行数据自动封装为一个对象
     */
    @Test
    public void testQuery(){
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        System.out.println(list);
    }

    /**
     * 一般用来执行聚合函数
     */
    @Test
    public void testQueryForObject(){
        String sql = "select count(*) from emp";
        Long count = template.queryForObject(sql, Long.class);
        System.out.println(count);
    }
}
