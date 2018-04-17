package com.j.ch13.dao;

import com.j.ch13.model.ConnectionMaker;
import com.j.ch13.model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    private ConnectionMaker connectionMaker;
    private DataSource dataSource;

    public UserDAO() {
        System.out.println("User DAO 기본생성자 생성");
    }

    public void add(User user)throws ClassNotFoundException,SQLException{

        Connection c = connectionMaker.makeConnection();
        System.out.println("직접 connection 연결해서 사용");

        PreparedStatement pstmt = c.prepareStatement("insert into mytempuser values (?,?,?)");
        pstmt.setString(1,user.getId());
        pstmt.setString(2,user.getPass());
        pstmt.setString(3,user.getName());
        pstmt.executeUpdate();
        pstmt.close();
        c.close();
    }

    public User get(String id)throws ClassNotFoundException,SQLException{

        Connection c = dataSource.getConnection();
        System.out.println("DataSource 사용");

        PreparedStatement preparedStatement = c.prepareStatement("select * from mytempuser where id=?");
        preparedStatement.setString(1,id);
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setPass(rs.getString("pass"));
        user.setName(rs.getString("name"));
        rs.close(); preparedStatement.close(); c.close();
        return user;
    }

    public ConnectionMaker getConnectionMaker() {
        return connectionMaker;
    }

    public void setConnectionMaker(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
