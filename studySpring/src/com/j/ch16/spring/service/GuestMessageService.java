package com.j.ch16.spring.service;

import com.j.ch16.spring.model.GuestMessage;
import com.j.ch16.spring.model.GuestMessageList;

//글쓰기와 목록조회를 할 서비스 클래스 및 인터페이스
public interface GuestMessageService {

    GuestMessage write(GuestMessage message);
    GuestMessageList getMessageList(int pageNum);

}
