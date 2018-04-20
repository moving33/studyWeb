package com.j.ch15.board.service;

import com.j.ch15.model.Article;

public class ReadArticleServiceImpl implements ReadArticleService{
    @Override
    public Article getArticleAndIncreaseReadCount(int id) throws ArticleNotFoundException {
        //id값이 0이 들어올경우 예외발생 코드

        if(id == 0){throw new ArticleNotFoundException();}

        return new Article();
    }
}
