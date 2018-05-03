package com.j.spring.board.service;

import java.util.List;

//글목록을 가져오는 서비스
public interface BoardListService<T> {
    //글의 총개수 카운트
    Integer getListCount(Object obj);
    //페이지에 보여줄 리스트 가져오기
    List<T> getBoardList(Object obj);
}
