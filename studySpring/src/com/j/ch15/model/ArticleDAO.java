package com.j.ch15.model;

public interface ArticleDAO {
    //글의 insert logic
    void insert(Article article);
    //count를 올려주는 logic 0
    void updateReadCount(int id,int i);
}
