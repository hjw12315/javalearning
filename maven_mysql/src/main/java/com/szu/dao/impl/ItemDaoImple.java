package com.szu.dao.impl;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.szu.dao.inter.ItemDao;
import com.szu.domain.Item;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ItemDaoImple implements ItemDao {
    public List<Item> findAll() throws Exception {
        InputStream inputStream= ItemDaoImple.class.getClassLoader()
                .getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        List<Item> list = null;
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        try(Connection connection = dataSource.getConnection()){
            String sql = "select id, ename from emp";
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                try(ResultSet rs = ps.executeQuery()){
                    list = new ArrayList<Item>();
                    while(rs.next()){
                        Item item = new Item();
                        item.setId(rs.getInt("id"));
                        item.setEname(rs.getString("ename"));
                        list.add(item);
                    }
                }
            }
        }
        return list;

//        Connection connection = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        List<Item> list = null;
//        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
//        try{
//            connection = dataSource.getConnection();
//            String sql = "select id, ename from emp";
//            ps = connection.prepareStatement(sql);
//            rs = ps.executeQuery();
//            list = new ArrayList<Item>();
//            while(rs.next()){
//                Item item = new Item();
//                item.setId(rs.getInt("id"));
//                item.setEname(rs.getString("ename"));
//                list.add(item);
//            }
//        }finally {
//            if(connection!=null)
//                connection.close();
//            if(ps!=null)
//                ps.close();
//            if(rs!=null)
//                rs.close();
//        }
//        return list;
    }
}
