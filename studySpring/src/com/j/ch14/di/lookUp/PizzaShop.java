/*추상 class와 method의 구현 */
package com.j.ch14.di.lookUp;

public abstract class PizzaShop {
    //각기 다른 역할을 하는 Pizza 객체를 리턴하는 추상Method
    public abstract Pizza makePizza();
    public abstract Pizza makePizzaVeggiPizza();
}
