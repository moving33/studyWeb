package com.j.spring.board.service;

import com.j.spring.board.dao.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteArticleServiceImpl implements DeleteArticleService{

    @Autowired
    private BoardDAO boardDAO;


    @Override
    public String getPass(Integer num) {
        return boardDAO.getPass(num);
    }

    @Override
    public void deleteArticle(Integer num) {
        boardDAO.deleteArticle(num);
    }

    public BoardDAO getBoardDAO() {
        return boardDAO;
    }

    public void setBoardDAO(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }
}
