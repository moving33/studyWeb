package com.j.spring.board.service;

public interface DeleteArticleService {

    //비번가져오고
    String getPass(Integer num);

    //삭제
    void deleteArticle(Integer num);

}
