package com.j.ch16.spring.dao;

import com.j.ch16.spring.model.GuestMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

//GuestMeageDao 를 상속받아 실제적인 DAO내용을 구현하는 클래스
public class JdbcTemplateGuestMessageDao implements GuestMessageDao{

    //Spring에서 제공하는 jdbcTemplate
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from GUESTBOOK_MESSAGE",Integer.class);
    }

    @Override
    public List<GuestMessage> select(int begin, int end) {
        /*return jdbcTemplate.query(
                "select * from GUESTBOOK_MESSAGE limit ?,?",
                new Object[]{begin-1,new Integer(5)},
                new GuestMessageRowMapper()
        );*/
        return null;
    }

    @Override
    public int insert(GuestMessage message) {
        int insertedCount = jdbcTemplate.update(
                "insert into guestbook_message(GUEST_NAME, MESSAGE, REGDATE) values " +
                        "(?,?,?)",
                message.getGuestName(),message.getMessage(),message.getRegdate()
        );
        return insertedCount;
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("delete from GUESTBOOK_MESSAGE where MESSAGE_ID=?",id);
    }

    @Override
    public int update(GuestMessage message) {
        return jdbcTemplate.update("update guestbook_message set MESSAGE = ? where MESSAGE_ID=?",
                message.getMessage(),message.getId());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
