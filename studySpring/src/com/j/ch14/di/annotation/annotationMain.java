package com.j.ch14.di.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class annotationMain {
    public static void main(String[] ar){
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("/com/j/ch14/di/annotation/applicationContext.xml");

        SimpleMovieLister simpleMovieLister = (SimpleMovieLister)context.getBean("simpleMovie");

        System.out.println(simpleMovieLister.getMovieFinder().getMovie());

    }
}
