/*
 DB와 연결하여 Connection 객체를 리턴해주는 클래스
 */

package com.j.ch13.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NConnectionMaker implements ConnectionMaker {

    public NConnectionMaker() {
        System.out.println("Real Connection 기본 생성자 생성");
    }

    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://192.168.137.128:3306/jsptest",
                "moving33","1234");
        return c;
    }
}
