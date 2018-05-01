package com.j.spring.board.dao;

import java.util.List;

public interface BoardDAO<T>{
    //전체 글수 or 검색한 글수
    int getListCount(Object o);

    //전체글 or 검색한 글 리스트
    List<T> getList(Object o);

    //글 입력
    void insertArticle(T t);

    //글 가져오기
    T getArticle(Integer num);

    //글 입력
    void updateArticle(T t);

    //비밀번호 가져오기
    String getPass(Integer num);

    //글삭제
    void deleteArticle(Integer num);

}
