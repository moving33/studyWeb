package com.j.ch17.spring.transactionTemplate;

//model class
public class OrderItem {
    private long id;
    private String item;
    private int qty;

    public OrderItem() {
    }

    public OrderItem(String item, int qty) {
        this.item = item;
        this.qty = qty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", qty=" + qty +
                '}';
    }
}
