package com.j.spring.board.service;

import com.j.spring.board.dao.BoardDAO;
import com.j.spring.board.model.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModifyArticleServiceImpl implements ModifyArticleService {

    @Autowired
    private BoardDAO boardDAO;

    @Override
    public BoardVO getArticle(Integer num) {
        return (BoardVO) boardDAO.getArticle(num);
    }

    @Override
    public String getPass(Integer num) {
        return boardDAO.getPass(num);
    }

    @Override
    public void updateArticle(BoardVO boardVO) {
        boardDAO.updateArticle(boardVO);
    }

    public BoardDAO getBoardDAO() {
        return boardDAO;
    }

    public void setBoardDAO(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }
}
