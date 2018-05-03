package com.j.spring.board.model;

import java.sql.Timestamp;

public class CommentVO {
    private String comment_num; //코멘트의 primary key
    private Integer num; //해당 글번호
    private String comment_writer; // 남긴사람
    private String comment; 
    private Timestamp regdate_comment;

    
    public String getcomment_num() {        
        return comment_num;
    }

    public void setcomment_num(String comment_num) {
        this.comment_num = comment_num;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getcomment_writer() {
        return comment_writer;
    }

    public void setcomment_writer(String comment_writer) {
        this.comment_writer = comment_writer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getregdate_comment() {
        return regdate_comment;
    }

    public void setregdate_comment(Timestamp regdate_comment) {
        this.regdate_comment = regdate_comment;
    }
}
