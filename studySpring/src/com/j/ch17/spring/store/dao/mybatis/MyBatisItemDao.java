package com.j.ch17.spring.store.dao.mybatis;

import com.j.ch17.spring.store.dao.inter.ItemDao;
import com.j.ch17.spring.store.model.Item;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class MyBatisItemDao implements ItemDao {

    private SqlSessionTemplate sqlSessionTemplate;

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }


    @Override
    public Item findById(Integer id) {
        String stmt = "com.j.ch17.spring.store.dao.mybatis.Item.findById";
        return (Item) sqlSessionTemplate.selectOne(stmt,id);
    }

    @Override
    public List<Item> itemList() {
        return sqlSessionTemplate.selectList("com.j.ch17.spring.store.dao.mybatis.Item.itemList");
    }
}
