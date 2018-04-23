package com.j.ch16.spring.model;

import org.springframework.stereotype.Component;

import java.sql.Date;

public class GuestMessage {
    private Integer id;
    private String guestName;
    private String message;
    private Date regdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "GuestMessage{" +
                "id=" + id +
                ", guestName='" + guestName + '\'' +
                ", message='" + message + '\'' +
                ", regdate=" + regdate +
                '}';
    }
}
