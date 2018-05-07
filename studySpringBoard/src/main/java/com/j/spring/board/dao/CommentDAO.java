package com.j.spring.board.dao;

import java.util.List;

//댓글 DAO
public interface CommentDAO<T> {

    //전체 코멘트 갯수
    int getCommentCount(Object o);

    List<T> getCommentList(Object o);

    //입력
    void insertComment(T t);

    //삭제
    void deleteComment(Integer num);

    //수정
    void ModifyComment(T t);

    //비밀번호 가져오기
    String getPass(Integer num);
}
