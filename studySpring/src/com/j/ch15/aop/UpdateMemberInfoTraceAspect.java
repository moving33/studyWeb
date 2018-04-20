package com.j.ch15.aop;

import com.j.ch15.member.service.UpdateInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class UpdateMemberInfoTraceAspect {

    @AfterReturning(pointcut = "args(memberId,info)" , argNames ="joinPoint,result,memberId,info", returning = "result" )
    public void traceReturn(JoinPoint joinPoint, boolean result, String memberId, UpdateInfo info){
        System.out.println("[UpdateMemberInfoTraceAdvice] 정보 수정 결과=" +
                result+",대상회원= "+memberId+",수정정보 = "+info+",실행한 메서드 이름 :"+joinPoint.getSignature().toShortString());

    }
}
