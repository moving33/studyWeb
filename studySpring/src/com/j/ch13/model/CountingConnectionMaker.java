/*

 단순히 Counting 기능을 담고 있는 객체
 ConnectionMaker interface 의 method를 Override 했지만,
 실질적인 Logic 부분은 위 class의 member인 ConnectionMaker 가 수행한다.
 */


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
