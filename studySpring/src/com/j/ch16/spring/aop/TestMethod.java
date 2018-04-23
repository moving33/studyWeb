package com.j.ch16.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class TestMethod {
    public void testMethod(){
        System.out.println("[전처리!!!!!!!!!]");
    }
}
