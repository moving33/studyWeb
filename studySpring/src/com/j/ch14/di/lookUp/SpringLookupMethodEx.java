package com.j.ch14.di.lookUp;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringLookupMethodEx {
    public static void main(String [] ar){
        ClassPathXmlApplicationContext
                context = new ClassPathXmlApplicationContext("/com/j/ch14/di/lookUp/applicationContext.xml");
        context.getBean("pizzaShop");

        try {
            PizzaShop pizzaShop = (PizzaShop) context.getBean("pizzaShop");
            Pizza firstPizza = pizzaShop.makePizza();
            System.out.println("First Pizza :" + firstPizza);

            Pizza secoundPizza = pizzaShop.makePizza();
            System.out.println("Secound Pizza : " + secoundPizza);

            Pizza veggiPizza = pizzaShop.makePizzaVeggiPizza();
            System.out.println("Veggi Pizza : " + veggiPizza);
        }finally {
            context.close();
        }

    }
}
