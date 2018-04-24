package com.j.ch17.spring.transactionTemplate;

import java.util.List;

//DAO interface
public interface Dao<T> {
    //item 저장
    long save(T t);
    // item 로드
    T load(long id);
    // 삭제
    int delete(long id);
    // 업데이트
    int update(T t);

    //저장된 item 로드
    List<T> loadAll();
}
