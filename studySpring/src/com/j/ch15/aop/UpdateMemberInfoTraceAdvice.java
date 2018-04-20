//정보수정 추적 결과 를 알려줄 녀석
package com.j.ch15.aop;

import com.j.ch15.member.service.UpdateInfo;
import org.aspectj.lang.JoinPoint;

public class UpdateMemberInfoTraceAdvice {
    public void traceReturn(JoinPoint joinPoint, boolean result, String memberId, UpdateInfo info){
        System.out.println("[UpdateMemberInfoTraceAdvice] 정보 수정 결과=" +
                result+",대상회원= "+memberId+",수정정보 = "+info+",실행한 메서드 이름 :"+joinPoint.getSignature().toShortString());

    }

}
