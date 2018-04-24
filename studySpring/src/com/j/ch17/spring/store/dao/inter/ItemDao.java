package com.j.ch17.spring.store.dao.inter;


import com.j.ch17.spring.store.model.Item;

import java.util.List;

public interface ItemDao {
    Item findById(Integer id);
    List<Item> itemList();
}
