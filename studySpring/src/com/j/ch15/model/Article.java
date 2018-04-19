package com.j.ch15.model;

public class Article {
    private int id; // 글의 id번호
    private ArticleDAO articleDAO;
    public Article(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArticleDAO getArticleDAO() {
        return articleDAO;
    }

    public void setArticleDAO(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }
}
