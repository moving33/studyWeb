package com.j.spring.board.model;

import java.sql.Timestamp;

public class CommentVO {
    private String comment_num; //코멘트의 primary key
    private Integer num; //해당 글번호
    private String comment_writer; // 남긴사람
    private String comment_pass; //비밀번호
    private String comment; 
    private Timestamp regdate_comment;


    public CommentVO(){

    }


    public String getComment_num() {
        return comment_num;
    }

    public void setComment_num(String comment_num) {
        this.comment_num = comment_num;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getComment_writer() {
        return comment_writer;
    }

    public void setComment_writer(String comment_writer) {
        this.comment_writer = comment_writer;
    }

    public String getComment_pass() {
        return comment_pass;
    }

    public void setComment_pass(String comment_pass) {
        this.comment_pass = comment_pass;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getRegdate_comment() {
        return regdate_comment;
    }

    public void setRegdate_comment(Timestamp regdate_comment) {
        this.regdate_comment = regdate_comment;
    }

    @Override
    public String toString() {
        return "CommentVO{" +
                "comment_num='" + comment_num + '\'' +
                ", num=" + num +
                ", comment_writer='" + comment_writer + '\'' +
                ", comment_pass='" + comment_pass + '\'' +
                ", comment='" + comment + '\'' +
                ", regdate_comment=" + regdate_comment +
                '}';
    }
}
