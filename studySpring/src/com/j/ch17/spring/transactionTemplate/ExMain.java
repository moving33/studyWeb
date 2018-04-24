package com.j.ch17.spring.transactionTemplate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExMain {
    public static void main(String[] ar){
        AnnotationConfigApplicationContext
                context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderItemClientBean orderItemClientBean = context.getBean(OrderItemClientBean.class);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Service 시작");
                orderItemClientBean.persistOrderItems();
            }
        };
        Thread testThread = new Thread(runnable);
        testThread.start();
    }
}
