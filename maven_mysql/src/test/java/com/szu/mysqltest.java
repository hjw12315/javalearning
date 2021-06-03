package com.szu;

import com.szu.dao.impl.ItemDaoImple;
import com.szu.domain.Item;
import org.junit.Test;

public class mysqltest {
    @Test
    public void findAllTest() throws Exception {
        for(Item item: new ItemDaoImple().findAll()){
            System.out.println(item);
        }
    }
}
