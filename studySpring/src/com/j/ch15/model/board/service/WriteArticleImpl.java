package com.j.ch15.model.board.service;

import com.j.ch15.model.Article;
import com.j.ch15.model.ArticleDAO;

public class WriteArticleImpl implements WriteArticleService{
    private ArticleDAO articleDAO;


    public WriteArticleImpl() {
    }

    public WriteArticleImpl(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

    @Override
    public void write(Article article) {

    }
}
