package com.j.ch14.di.Autowiring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ByNameEx {
    public static void main(String[] ar){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/com/j/ch14/di/Autowiring/applicationContext.xml");

        //byName
        Customer customer = (Customer)context.getBean("customer"); //autowire 기능사용
        Customer customer2 = (Customer)context.getBean("cutomer2"); // 직접 값 설정


        System.out.println(customer.getAddress().getFulladdress());
        System.out.println(customer2.getAddress().getFulladdress());

        //abstract

        SystemMonitor s1 = context.getBean("roomMonitor",SystemMonitor.class);
        SystemMonitor s2 = context.getBean("doorMonitor",SystemMonitor.class);

        System.out.println("s1 : "+s1);
        System.out.println("s2 : "+s2);

    }
}
