package com.j.spring.logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggerAspect {
    protected Log log = LogFactory.getLog(LoggerAspect.class);
    static String name;
    static String type;

    @Around("execution(* com.j.spring.board.dao..*.*(..)) || execution(* com.j.spring.board.controller..*.*(..)) || execution(* com.j.spring.board.service..*.*(..))")
    public Object logPrint(ProceedingJoinPoint joinPoint)throws Throwable{
        type = joinPoint.getSignature().getDeclaringTypeName();

        if(type.indexOf("DAO") > -1){
            name ="DAO\t: ";
        }
        if(type.indexOf("Controller") > -1){
            name="Controller\t: ";
        }if(type.indexOf("Service") > -1){
            name="Service\t: ";
        }

        log.info(name+type+"."+joinPoint.getSignature().getName()+"()");

        return joinPoint.proceed();
    }
}
