package com.j.ch14.di.lifeCycle;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.Resource;

public class MyLifeBeanTest {
    public static void main(String[] ar){
        System.out.println("Spring FrameWork 사용...");
        /*
        BeanFactory 사용
        Resource resource
                = new ClassPathResource("/com/j/ch14/di/lifeCycle/applicationContext.xml");
        XmlBeanFactory factory = new XmlBeanFactory(resource);
        System.out.println("Spring FrameWork 로딩 성공...");
        factory.addBeanPostProcessor(new CustomBeanPostProc());
        MyLifeBean bean = (MyLifeBean)factory.getBean("myLifeBean");*/

        //applicationContext 사용..
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/com/j/ch14/di/lifeCycle/applicationContext.xml");
        MyLifeBean bean = (MyLifeBean)context.getBean("myLifeBean");

        bean.sayHello();
        context.close();

    }
}
