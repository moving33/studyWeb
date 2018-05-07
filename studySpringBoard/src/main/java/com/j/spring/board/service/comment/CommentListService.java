package com.j.spring.board.service.comment;

import java.util.List;

public interface CommentListService<T> {

    //코멘트 카운트
    Integer getCommentListCount(Object o);
    //페이지에 보여줄 코멘트 리스트 가져오기
    List<T> getCommentList(Object o);
}
