package com.j.ch14.di.Autowiring;

public class SystemMonitor {

    private int periodTime;
    private String sender;

    public int getPeriodTime() {
        return periodTime;
    }

    public void setPeriodTime(int periodTime) {
        this.periodTime = periodTime;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString(){
        return "periodTime : "+String.valueOf(periodTime)+" / sender : "+sender;
    }
}
