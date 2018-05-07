package com.j.spring.board.service.comment;

public interface DeleteCommentService {

    //비번가져오기
    String getPass(Integer num);

    //지우기
    void deleteComment(Integer num);

}
