package com.j.ch17.spring.store.dao.mybatis;

import com.j.ch17.spring.store.dao.inter.PaymentInfoDao;
import com.j.ch17.spring.store.model.PaymentInfo;
import org.mybatis.spring.SqlSessionTemplate;

public class MyBatisPaymentInfoDao implements PaymentInfoDao {

    private SqlSessionTemplate sqlSessionTemplate;

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }


    public Integer nextVal() {
        String stmt = "com.j.ch17.spring.store.dao.mybatis.PaymentInfo.nextVal";
        return (Integer)sqlSessionTemplate.selectOne(stmt);
    }


    @Override
    public PaymentInfo insert(PaymentInfo paymentInfo) {
        paymentInfo.setId(nextVal()+1);
        sqlSessionTemplate.insert(
                "com.j.ch17.spring.store.dao.mybatis.PaymentInfo.insert",
                paymentInfo
        );
        return paymentInfo;
    }
}
