package com.j.spring.board.model;

import java.sql.Timestamp;

public class BoardVO {
    private int num;
    private String writer;
    private String email;
    private String subject;
    private String pass;
    private int readcount;
    private String content;
    private String article_type;
    private Timestamp regdate;

    public BoardVO() {
    }

    public Timestamp getRegdate() {
        return regdate;
    }

    public void setRegdate(Timestamp regdate) {
        this.regdate = regdate;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getReadcount() {
        return readcount;
    }

    public void setReadcount(int readcount) {
        this.readcount = readcount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getArticle_type() {
        return article_type;
    }

    public void setArticle_type(String article_type) {
        this.article_type = article_type;
    }



    @Override
    public String toString() {
        return "BoardVO{" +
                "num=" + num +
                ", writer='" + writer + '\'' +
                ", email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", pass='" + pass + '\'' +
                ", readcount=" + readcount +
                ", content='" + content + '\'' +
                ", article_type='" + article_type + '\'' +
                ", regdate=" + regdate
                +" }";
    }
}
