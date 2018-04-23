/*공통기능을 제공할 Advice 작성*/



package com.j.ch15.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class ProfilingAdvice {

    public Object trace(ProceedingJoinPoint joinPoint)throws Throwable{
        //joinPoint가 가져오는 이름 ( 수행하는 메서드 이름 )
        String signatureString = joinPoint.getSignature().toShortString();
        long start = System.currentTimeMillis();
        System.out.println("[Advice] "+signatureString+".. start");

        try{
        Object result = joinPoint.proceed();//메서드 수행

        return result;

        }finally {
            long finish = System.currentTimeMillis();
            System.out.println("[Advice] "+signatureString+".. end");
            System.out.println("[Advice] 실행 시간 : "+(finish-start)+" ms");
        }


    }
}
