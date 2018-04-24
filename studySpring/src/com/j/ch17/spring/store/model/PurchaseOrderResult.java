package com.j.ch17.spring.store.model;

//구매주문결과
public class PurchaseOrderResult {
    private Item item; //모델
    private PaymentInfo paymentInfo; //주문정보
    private PurchaseOrder order; //구입정보

    public PurchaseOrderResult(Item item, PaymentInfo paymentInfo, PurchaseOrder order) {
        this.item = item;
        this.paymentInfo = paymentInfo;
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public PurchaseOrder getOrder() {
        return order;
    }

    public void setOrder(PurchaseOrder order) {
        this.order = order;
    }
}
