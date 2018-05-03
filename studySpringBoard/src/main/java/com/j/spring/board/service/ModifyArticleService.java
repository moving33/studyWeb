package com.j.spring.board.service;

import com.j.spring.board.model.BoardVO;

public interface ModifyArticleService {

    //글 가져오고
    BoardVO getArticle(Integer num);
    //비번가져와서
    String getPass(Integer num);
    //수정
    void updateArticle(BoardVO boardVO);

}
