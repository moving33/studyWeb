package com.j.ch15.board.service;

import com.j.ch15.model.Article;

public interface ReadArticleService {
    //작성
    Article getArticleAndIncreaseReadCount(int id)throws ArticleNotFoundException;
}
