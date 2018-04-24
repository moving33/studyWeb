package com.j.ch17.spring.store.model;

//구매주문요구사항
public class PurchaseOrderRequest {
    private Integer itemId;
    private String address;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PurchaseOrderRequest{" +
                "itemId=" + itemId +
                ", address='" + address + '\'' +
                '}';
    }
}
