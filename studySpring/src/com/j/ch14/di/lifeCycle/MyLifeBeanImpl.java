/*MyLifeBean을 구현한 클래스*/

package com.j.ch14.di.lifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyLifeBeanImpl implements
        MyLifeBean,BeanNameAware,BeanFactoryAware,InitializingBean,DisposableBean,ApplicationContextAware {
    //BeanNameAware = bean의 이름을 설정을 하는 interface
    //BeanFactoryAware = beanFactory의 구현 Class의 이름을 설정하는 interface
    //InitializingBean = bean의 property 속성 설정 후처리를 담당하는 interface
    //DisposableBean = context와의 연결을 close() 닫은 후 처리를 담당하는 interface

    private String greeting;
    private String beanName;
    private BeanFactory beanFactory;
    private ApplicationContext applicationContext;

    @Override
    public void sayHello() {
        System.out.println("Bean의 sayHello() 실행 :"+greeting+beanName+"!!!");
    }

    public MyLifeBeanImpl() {
        System.out.println("1. Bean의 생성자 실행");
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
        System.out.println("2. Bean의 Greeting setter Method 실행");
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("3. Bean의 이름 설정");
        this.beanName = beanName;
        System.out.println("---> "+this.beanName);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("4. Bean Factory 설정");
        this.beanFactory = beanFactory;
        System.out.println("---> "+this.beanFactory.getClass());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("4. Bean applicationContext 구현 Class 설정");
        this.applicationContext = applicationContext;
        System.out.println("---> "+this.applicationContext.getClass());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("6. Property 설정 완료");
    }

    public void init(){
        System.out.println("7. init() 수행");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean객체의 LifeCycle 종료");
    }


    public String getGreeting() {
        return greeting;
    }
    public String getBeanName() {
        return beanName;
    }
    public BeanFactory getBeanFactory() {return beanFactory;}
    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
