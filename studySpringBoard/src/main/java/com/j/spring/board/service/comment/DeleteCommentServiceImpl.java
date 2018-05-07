package com.j.spring.board.service.comment;

import com.j.spring.board.dao.CommentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCommentServiceImpl implements DeleteCommentService{

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public String getPass(Integer num) {
        return commentDAO.getPass(num);
    }

    @Override
    public void deleteComment(Integer num) {
        commentDAO.deleteComment(num);
    }


}
