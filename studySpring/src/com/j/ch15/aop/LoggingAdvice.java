package com.j.ch15.aop;

public class LoggingAdvice {
    public void before(){
        System.out.println("[LoggingAdvice] : before ...");
    }
    //Exception 없이 수행완료시
    public void afterReturning(Object ret){
        System.out.println("[LoggingAdvice] : return 이후 실행 리턴값  "+ret);
    }

    //Exception 발생시
    public void afterThrowing(Throwable ex){
        System.out.println("[LoggingAdvice] : thrwowing 이후 실행 Exception :"+ex.getClass().getName());
    }

    //after
    public void after(){
        System.out.println();
        System.out.println("[LoggingAdvice] : After ...\n---------------------------------------------");
    }
}
