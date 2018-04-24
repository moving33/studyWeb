package com.j.ch16.spring.dao;

import com.j.ch16.spring.model.GuestMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("namedParamGuestMessageDao")
public class NamedParamGuestMessageDao implements GuestMessageDao{

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return namedParameterJdbcTemplate;
    }

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public int count() {
        Map<String,Object> stringObjectMap = new HashMap<>();
        return namedParameterJdbcTemplate.queryForObject(
                "select count(*) from GUESTBOOK_MESSAGE",stringObjectMap,Integer.class
        );
    }

    @Override
    public List<GuestMessage> select(int begin, int end) {
        return null;
    }

    @Override
    public int insert(GuestMessage message) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int update(GuestMessage message) {
        return 0;
    }
}
