package com.j.ch14.di.lookUp;

public class A {
    //비지니스 로직을 담당하고 있는 객체의 선언
    private Pizza pizza;
    //set method를 사용하여 xml선언시 property tag를 설정한다.
    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
}
