package com.j.ch17.spring.store.service;

import com.j.ch17.spring.store.dao.inter.ItemDao;
import com.j.ch17.spring.store.dao.inter.PaymentInfoDao;
import com.j.ch17.spring.store.dao.inter.PurchaseOrderDao;
import com.j.ch17.spring.store.model.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class MyBatisOrderServiceImpl implements PlaceOrderService {

    //item 처리 dao
    private ItemDao itemDao;
    //주문정보 처리 dao
    private PaymentInfoDao paymentInfoDao;
    //구입요청 처리 dao
    private PurchaseOrderDao purchaseOrderDao;
    //Spring의 Transaction 사용

    @Transactional
    @Override
    public PurchaseOrderResult order(PurchaseOrderRequest purchaseOrderRequest)
            throws ItemNotFoundException {
        //구입요청객체에서 아이템번호를 추출해 검색
        Item item = itemDao.findById(purchaseOrderRequest.getItemId());

        //요청한 Item 없을시 예외처리
        if(item == null)throw new ItemNotFoundException(purchaseOrderRequest.getItemId());

        //검색한 item의 가격을 넣은 주문정보객체 생성
        PaymentInfo paymentInfo = new PaymentInfo(item.getPrice());
        //주문정보를 db에 넣는다.
        paymentInfo = paymentInfoDao.insert(paymentInfo);

        //item의 Id, 주문자의 주소 , 주문번호 를 넣은 구입정보객체 생성
        PurchaseOrder purchaseOrder = new PurchaseOrder(
                item.getId(),
                purchaseOrderRequest.getAddress(),
                paymentInfo.getId()
                );
        //구입정보를 db에 넣는다.
        purchaseOrderDao.insert(purchaseOrder);
        //구입서비스 객체를 리턴한다 (주문한 item,주문정보,구입정보를 가지고 있는)
        return new PurchaseOrderResult(item,paymentInfo,purchaseOrder);
    }

    @Transactional
    @Override
    public List<Item> listAll() {
        return itemDao.itemList();
    }






    public ItemDao getItemDao() {
        return itemDao;
    }

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public PaymentInfoDao getPaymentInfoDao() {
        return paymentInfoDao;
    }

    public void setPaymentInfoDao(PaymentInfoDao paymentInfoDao) {
        this.paymentInfoDao = paymentInfoDao;
    }

    public PurchaseOrderDao getPurchaseOrderDao() {
        return purchaseOrderDao;
    }

    public void setPurchaseOrderDao(PurchaseOrderDao purchaseOrderDao) {
        this.purchaseOrderDao = purchaseOrderDao;
    }


}
