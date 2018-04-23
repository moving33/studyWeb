package com.j.ch16.spring.service;

import org.springframework.stereotype.Component;

@Component("methodImpl")
public class MethodImpl {
    public void test(){
        System.out.println("MethodImpl method실행");
    }
}
