package com.j.ch17.spring.store.dao.mybatis;

import com.j.ch17.spring.store.dao.inter.PurchaseOrderDao;
import com.j.ch17.spring.store.model.PurchaseOrder;
import org.mybatis.spring.SqlSessionTemplate;

public class MyBatisPurchaseOrder implements PurchaseOrderDao {
    private SqlSessionTemplate sqlSessionTemplate;

    public Integer nextVal(){
        String stmt = "com.j.ch17.spring.store.dao.mybatis.PurchaseOrder.nextVal";
        return (Integer)(sqlSessionTemplate.selectOne(stmt) != null ?
                sqlSessionTemplate.selectOne(stmt) : 0);
    }

    @Override
    public void insert(PurchaseOrder order) {
        order.setId(nextVal()+1);
        sqlSessionTemplate.insert(
                "com.j.ch17.spring.store.dao.mybatis.PurchaseOrder.insert"
                ,order
        );
    }

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }


}
