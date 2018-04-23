package com.j.ch16.spring.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

//@Aspect
//@Order(0)
public class BeforeAdvice {
    //@Before("execution(* com.j.ch16.spring.*.*(..))")
    public void beforeLog(){
        System.out.println("[사전 처리] Business Logic processed before..");
    }
}
