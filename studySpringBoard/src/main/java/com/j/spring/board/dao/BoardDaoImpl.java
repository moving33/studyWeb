package com.j.spring.board.dao;

import com.j.spring.board.model.BoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardDaoImpl implements BoardDAO<BoardVO> {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int getListCount(Object o) {
        Map<String , Object> map2 = new HashMap<String, Object>();
        //param Object를 amp타입으로 변환?
        map2 = (Map<String, Object>)o;

        //System.out.println(map.get("search_type"));

        if(map2.get("search_type").equals("all") || map2.get("search_type") == ""){
            return sqlSessionTemplate.selectOne("spring.dao.board.getAllCount",o);
        }else {
            return sqlSessionTemplate.selectOne("spring.dao.board.getOptionCount",o);
        }
    }

    @Override
    public List<BoardVO> getList(Object o) {
        Map<String,Object> map = new HashMap<>();
        map = (Map<String, Object>) o;
        List<BoardVO> boardVo = null;
        if(map.get("search_type") == null || map.get("search_type") == ""){
            System.out.println("실행");
            return boardVo = sqlSessionTemplate.selectList("spring.dao.board.getList", map);
        }

        if(map.get("search_type").equals("all")) {
            return boardVo = sqlSessionTemplate.selectList("spring.dao.board.getAllList", o);
        }else if(map.get("search_type").equals("subject")){
            return boardVo = sqlSessionTemplate.selectList("spring.dao.board.getSubjectList", o);
        }else if(map.get("search_type").equals("content")){
            return boardVo = sqlSessionTemplate.selectList("spring.dao.board.getContentList", o);
        }else if(map.get("search_type").equals("writer")){
            return boardVo = sqlSessionTemplate.selectList("spring.dao.board.getWriterList", o);
        }else {
            return boardVo;
        }
    }

    @Override
    public void insertArticle(BoardVO boardVO) {
        sqlSessionTemplate.insert(
                "spring.dao.board.insertArticle",boardVO
        );
    }

    @Override
    public BoardVO getArticle(Integer num) {
        sqlSessionTemplate.update(
                "spring.dao.board.upReadCount",num
        );

        return sqlSessionTemplate.selectOne(
                "spring.dao.board.getArticle",num
        );

    }

    @Override
    public void updateArticle(BoardVO boardVO) {
        sqlSessionTemplate.update(
                "spring.dao.board.modifyArticle",boardVO
        );
    }

    @Override
    public String getPass(Integer num) {
        return sqlSessionTemplate.selectOne(
                "spring.dao.board.getPass",num
        );
    }

    @Override
    public void deleteArticle(Integer num) {
        sqlSessionTemplate.delete(
                "spring.dao.board.deleteArticle",num
        );
    }

    @Override
    public void test() {

        System.out.println("test");

        sqlSessionTemplate.selectOne(
                "spring.dao.board.test");
    }

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
}
