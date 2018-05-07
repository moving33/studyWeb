package com.j.spring.board.service.comment;

import com.j.spring.board.dao.CommentDAO;
import com.j.spring.board.model.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentListServiceImpl implements CommentListService<CommentVO>{

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public Integer getCommentListCount(Object o) {
        return commentDAO.getCommentCount(o);
    }

    @Override
    public List<CommentVO> getCommentList(Object o) {
        return commentDAO.getCommentList(o);
    }

    public CommentDAO getCommentDAO() {
        return commentDAO;
    }

    public void setCommentDAO(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }
}
