package com.j.ch17.spring.store.service;

import com.j.ch17.spring.store.model.Item;
import com.j.ch17.spring.store.model.ItemNotFoundException;
import com.j.ch17.spring.store.model.PurchaseOrderRequest;
import com.j.ch17.spring.store.model.PurchaseOrderResult;

import java.util.List;

//구매서비스를 추상화한 인터페이스
public interface PlaceOrderService {
    //주문서비스
    public PurchaseOrderResult order(PurchaseOrderRequest purchaseOrderRequest)throws ItemNotFoundException;
    //검색 서비스
    public List<Item> listAll();
}
