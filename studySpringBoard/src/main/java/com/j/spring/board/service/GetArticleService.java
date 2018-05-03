package com.j.spring.board.service;

import com.j.spring.board.model.BoardVO;


public interface GetArticleService {
    BoardVO getArticle(Integer num);
}
