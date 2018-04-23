package com.j.ch16.spring.dao;

import com.j.ch16.spring.model.GuestMessage;

import java.sql.ResultSet;
import java.sql.SQLException;


//Row mapper <- spring에서 ResultSet의 역할을 매핑키는 클래스...?
    public class GuestMessageRowMapper implements org.springframework.jdbc.core.RowMapper<GuestMessage> {
        @Override
        public GuestMessage mapRow(ResultSet resultSet, int i) throws SQLException {
            GuestMessage message = new GuestMessage();
            message.setId(resultSet.getInt("MESSAGE_ID"));
            message.setGuestName(resultSet.getString("GUEST_NAME"));
            message.setMessage(resultSet.getString("MESSAGE"));
            message.setRegdate(resultSet.getDate("REGDATE"));
            return message;
        }
}
