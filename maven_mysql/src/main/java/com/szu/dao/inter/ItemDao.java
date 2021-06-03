package com.szu.dao.inter;

import java.io.IOException;
import java.util.List;
import com.szu.domain.Item;

public interface ItemDao {
    public List<Item> findAll() throws Exception;
}
