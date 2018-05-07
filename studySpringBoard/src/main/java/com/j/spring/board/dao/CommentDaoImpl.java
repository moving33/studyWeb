package com.j.spring.board.dao;

import com.j.spring.board.model.CommentVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDAO<CommentVO> {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int getCommentCount(Object o) {
        //map  = (Map<String, Object>) o;
        return sqlSessionTemplate.selectOne("spring.dao.comment.getListCount",o);

    }

    @Override
    public List<CommentVO> getCommentList(Object object) {
        return sqlSessionTemplate.selectList(
                "spring.dao.comment.getList",object
        );
    }

    @Override
    public void insertComment(CommentVO commentVO) {
        sqlSessionTemplate.insert("spring.dao.comment.insertComment",commentVO);
    }

    @Override
    public void ModifyComment(CommentVO commentVO) {
        sqlSessionTemplate.update("spring.dao.comment.modifyComment",commentVO);
    }

    @Override
    public void deleteComment(Integer num) {
        sqlSessionTemplate.delete("spring.dao.comment.deleteComment",num);
    }

    @Override
    public String getPass(Integer num) {
        return sqlSessionTemplate.selectOne("spring.dao.comment.getPass",num);
    }

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
}
