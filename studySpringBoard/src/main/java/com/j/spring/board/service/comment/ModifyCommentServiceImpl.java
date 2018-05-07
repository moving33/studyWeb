package com.j.spring.board.service.comment;

import com.j.spring.board.dao.CommentDAO;
import com.j.spring.board.model.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModifyCommentServiceImpl implements ModifyCommentService<CommentVO> {

    @Autowired
    private CommentDAO commentDAO;


    @Override
    public String getPass(Integer num) {
        return commentDAO.getPass(num);
    }

    @Override
    public void modifyComment(CommentVO commentVO) {
        commentDAO.ModifyComment(commentVO);
    }
}
