package com.j.spring.board.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDAO {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    //전체 글수 리턴
    public int getListCount() {
        int result = sqlSessionTemplate.selectOne("spring.dao.board.getAllCount");
        return result == 0 ? 100 : 1000;

    }

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
}
