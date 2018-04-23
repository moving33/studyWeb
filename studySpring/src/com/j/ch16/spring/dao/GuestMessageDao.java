package com.j.ch16.spring.dao;

//abstract DAO

import com.j.ch16.spring.model.GuestMessage;

import java.util.List;

public interface GuestMessageDao {
    //count means total article count
    public int count();

    //select from page views articles
    public List<GuestMessage> select(int begin, int end);

    //CRUD from table GuestBookMessage
    public int insert(GuestMessage message);

    public int delete(int id);

    public int update(GuestMessage message);
}
