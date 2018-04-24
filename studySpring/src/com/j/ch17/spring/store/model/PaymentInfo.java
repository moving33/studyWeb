package com.j.ch17.spring.store.model;

//결제정보 Model
public class PaymentInfo {

    private Integer id;
    private int price;

    public PaymentInfo() {
    }

    public PaymentInfo(int price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PaymentInfo{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}
