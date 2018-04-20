package com.j.ch15.model;

import com.j.ch15.model.Article;
import com.j.ch15.model.ArticleDAO;

public class OracleArticleDAO implements ArticleDAO {
    @Override
    public void insert(Article article) {
        System.out.println("OracleArticleDAO : insert method ...");
    }

    @Override
    public void updateReadCount(int id, int i) {
        System.out.println("OracleArticleDAO : updateCount method ...");
    }
}
