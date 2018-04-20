package com.j.ch15.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

//관심사 등록
@Aspect
@Order(0)
public class LoggingAspect {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_WHITE = "\u001B[37m";

    @Before("PublicPointcut.publicMethod()")
    public void before(){
        System.out.println("[Before]..");
    }

    @AfterReturning(pointcut = "com.j.ch15.aop.PublicPointcut.publicMethod()",returning = "ret")
    public void afterReturning(Object ret){
        System.out.println("[afterReturning] return value = "+ret.toString());
    }

    @AfterThrowing(pointcut = "com.j.ch15.aop.PublicPointcut.publicMethod()",throwing = "ex")
    public void afterThrowing(Throwable ex){
        System.out.println("[AfterThrowing] 메서드 실행중 예외 발생 : "+ex.getClass().getName());
    }
    @After("com.j.ch15.aop.PublicPointcut.publicMethod()")
    public void afterFinally(){
        System.out.println(ANSI_RED+"[afterFinally]..\n"+ANSI_WHITE);
    }
}
