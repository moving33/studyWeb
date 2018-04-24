package com.j.ch17.spring.store.test;

import com.j.ch17.spring.store.model.Item;
import com.j.ch17.spring.store.model.PurchaseOrderRequest;
import com.j.ch17.spring.store.model.PurchaseOrderResult;
import com.j.ch17.spring.store.service.PlaceOrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class ApplicationTest {
    //주문서비스객체 선언
    private PlaceOrderService placeOrderService;
    private List<Item> itemList;

    //생성자 <주문서비스객체를 Spring Container에서 가져옴>
    public ApplicationTest() {
        ClassPathXmlApplicationContext
                context = new ClassPathXmlApplicationContext(
                "/com/j/ch17/spring/store/xml/transactionMybatis.xml"
        );
        //서비스 구현객체 Spring Container에서 추출
        placeOrderService = (PlaceOrderService) context.getBean("placeOrderService");
    }

    //주문하기
    public void order(int itemId, String address) {
        //주문요청 객체 생성
        PurchaseOrderRequest orderRequest
                = new PurchaseOrderRequest();
        orderRequest.setItemId(itemId);
        orderRequest.setAddress(address);

        //서비스처리해서 주문상태 정보가져옴
        PurchaseOrderResult orderResult = placeOrderService.order(orderRequest);

        System.out.println("주문상태정보");
        System.out.println("아이템 : " + orderResult.getItem().getId());
        System.out.println("가 격 : " + orderResult.getPaymentInfo().getPrice());
        System.out.println("주 문 번 호 : " + orderResult.getPaymentInfo().getId());
    }

    public static void main(String[] ar) {

        int selectItem = 0;
        String addressHome ="";

        ApplicationTest test = new ApplicationTest();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------ITEM LIST ------------");
        test.setItemList(test.getPlaceOrderService().listAll());
        for (Item item : test.getItemList()) {
            System.out.println(item.toString());
        }


        while(true) {
            try {

                System.out.print("사고 싶은 품목의 id를 선택해주세요 :");
                selectItem = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println(selectItem);
                System.out.println("숫자를 입력해주세요");
            }

            System.out.print("받으실 주소를 입력해주세요 : ");
            addressHome  = scanner.nextLine().trim();
            test.order(selectItem,addressHome);
            System.out.println();

            System.out.println("주문이 완료 되었습니다!");
            break;

        }


    }

    public PlaceOrderService getPlaceOrderService() {
        return placeOrderService;
    }

    public void setPlaceOrderService(PlaceOrderService placeOrderService) {
        this.placeOrderService = placeOrderService;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
