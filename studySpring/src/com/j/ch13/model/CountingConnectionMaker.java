package com.j.ch13.model;

import java.sql.Connection;
import java.sql.SQLException;

public class CountingConnectionMaker implements ConnectionMaker {

    int count = 0;
    private ConnectionMaker realConnectionMaker;

    public CountingConnectionMaker() {
        System.out.println("CountingConnectionMaker 기본생성자 생성");
    }

    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        this.count++;
        return realConnectionMaker.makeConnection();
    }

    public int getCount(){
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ConnectionMaker getRealConnectionMaker() {
        return realConnectionMaker;
    }

    public void setRealConnectionMaker(ConnectionMaker realConnectionMaker) {
        this.realConnectionMaker = realConnectionMaker;
    }
}
