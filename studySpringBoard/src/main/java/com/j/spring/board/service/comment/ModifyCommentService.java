package com.j.spring.board.service.comment;

public interface ModifyCommentService<T> {

    //비번가져오기
    String getPass(Integer num);

    //수정
    void modifyComment(T t);

}
