package com.j.spring.board.service.comment;

import com.j.spring.board.dao.CommentDAO;
import com.j.spring.board.model.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentInsertServiceImpl implements CommentInsertService<CommentVO> {

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public void insertComment(CommentVO commentVO) {
        commentDAO.insertComment(commentVO);
    }

    public CommentDAO getCommentDAO() {
        return commentDAO;
    }

    public void setCommentDAO(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }
}
