/*
 point cut 설정 Class

 */

package com.j.ch15.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PublicPointcut {
    //publicMethod()로 설정한 위의 조건을 만족하는 지점에 Advice를 사용하겠다라고 명시
    @Pointcut("execution(public * com.j.ch15..*(..))")
    public void publicMethod(){}
}
