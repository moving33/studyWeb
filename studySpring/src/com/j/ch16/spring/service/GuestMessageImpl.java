package com.j.ch16.spring.service;

import com.j.ch16.spring.dao.GuestMessageDao;
import com.j.ch16.spring.model.GuestMessage;
import com.j.ch16.spring.model.GuestMessageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Collections;
import java.util.List;

public class GuestMessageImpl implements GuestMessageService{

    //표시할 페이지 개수
    public static final int DEFUALT_PAGE_SIZE = 20;
    public int pageSize = DEFUALT_PAGE_SIZE;

    private GuestMessageDao guestMessageDao;

    @Override
    public GuestMessage write(GuestMessage message) {
        message.setRegdate(new Date(System.currentTimeMillis()));
        guestMessageDao.insert(message);
        return message;
    }

    @Override
    public GuestMessageList getMessageList(int pageNum) {
        int totalCount = guestMessageDao.count();
        if(totalCount == 0){
            return new GuestMessageList(0,0,0,0,
                    Collections.<GuestMessage>emptyList());
        }
        int begin = (pageNum -1)* pageSize+1;
        int end = pageNum * pageSize;
        if(end > totalCount)end = totalCount;

        List<GuestMessage> messages = guestMessageDao.select(begin,end);
        return new GuestMessageList(totalCount,pageNum,begin,end,messages);
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public GuestMessageDao getGuestMessageDao() {
        return guestMessageDao;
    }

    public void setGuestMessageDao(GuestMessageDao guestMessageDao) {
        this.guestMessageDao = guestMessageDao;
    }
}
