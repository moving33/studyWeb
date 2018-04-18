package com.j.ch14.di.lifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//Bean객체의 초기화 전 과 후의 처리를 담당하는 interface
public class CustomBeanPostProc implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("5. init() 전에 Bean의 처리를 실행");
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("8. init() 후 Bean의 처리를 실행");
        return o;
    }
}
