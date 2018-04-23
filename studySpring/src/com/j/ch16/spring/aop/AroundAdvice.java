package com.j.ch16.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

//@Aspect
public class AroundAdvice {
    //@Around("execution(* com.j.ch16.spring.dao.JdbcTemplateGuestMessageDao.delete(..))")
    public Object aroundLog(ProceedingJoinPoint joinPoint)throws Throwable{
        System.out.println("aroundLog!!!!!");
        int ar = (int)joinPoint.getArgs()[0];
        if(ar == 1){
            System.out.println("1번 아이디는 이미 삭제하였습니다.");
            return 0;
        }
        return joinPoint.proceed();

    }
}
