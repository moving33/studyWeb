package com.j.spring.board.service;


import com.j.spring.board.dao.BoardDAO;
import com.j.spring.board.model.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardListServiceImpl implements BoardListService<BoardVO> {

    @Autowired
    private BoardDAO boardDAO;

    @Override
    public Integer getListCount(Object obj) {
        return boardDAO.getListCount(obj);
    }

    @Override
    public List<BoardVO> getBoardList(Object obj) {
        return boardDAO.getList(obj);
    }


    public BoardDAO getBoardDAO() {
        return boardDAO;
    }


    public void setBoardDAO(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }
}
