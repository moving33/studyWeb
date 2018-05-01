package com.j.spring.board.dao;

import com.j.spring.board.model.BoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Repository
public class BoardDaoImpl implements BoardDAO<BoardVO> {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int getListCount(Object o) {
        Map<String , Object> map = new HashMap<>();
        //param Object를 amp타입으로 변환?
        map = (Map<String, Object>)o;

        if(map.get("search_type").equals("all")){
            return sqlSessionTemplate.selectOne("spring.dao.board.getAllCount",o);
        }else
            return sqlSessionTemplate.selectOne("spring.dao.board.getOptionCount",o);

    }

    @Override
    public List<BoardVO> getList(Object o) {
        List<BoardVO> boardVo = sqlSessionTemplate.selectList("spring.dao.board.getList",o);
        return boardVo;
    }

    @Override
    public void insertArticle(BoardVO boardVO) {

    }

    @Override
    public BoardVO getArticle(Integer num) {
        return null;
    }

    @Override
    public void updateArticle(BoardVO boardVO) {

    }

    @Override
    public String getPass(Integer num) {
        return null;
    }

    @Override
    public void deleteArticle(Integer num) {

    }

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
}
