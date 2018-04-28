package com.j.spring.ch20.common;

import org.springframework.stereotype.Component;

@Component
public class CommonLoggerImpl implements CommonLogger {
    public void log(String msg) {
        System.out.println("CommonLogger - "+msg);
    }
}
