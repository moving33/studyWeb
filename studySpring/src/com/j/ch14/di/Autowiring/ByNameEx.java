package com.j.ch14.di.Autowiring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ByNameEx {
    public static void main(String[] ar){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/com/j/ch14/di/Autowiring/applicationContext.xml");
        Customer customer = (Customer)context.getBean("customer");


        System.out.println(customer.getAddress().getFulladdress());

    }
}
