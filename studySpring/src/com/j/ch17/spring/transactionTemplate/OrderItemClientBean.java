package com.j.ch17.spring.transactionTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

//DAO구현 클래스를 사용하는 Service 객체
@Component
public class OrderItemClientBean {
    @Autowired
    private PlatformTransactionManager transactionManager;
    //DAO 구현객체 들어옴 (OrderItemJdbcTemplateDao)
    @Autowired
    private Dao<OrderItem> dao;


    public void persistOrderItems(){
        TransactionTemplate template  = new TransactionTemplate(transactionManager);
        //Result callback이 없는녀석의 추상메서드로 쿼리문을 실행.
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    long id = dao.save(new OrderItem("슈퍼파워건전지", 15));
                    System.out.println("id generated: " + id);
                    id = dao.save(new OrderItem("삼성 256G SSD", 2000));
                    System.out.println("id generated: " + id);
                }catch (Exception e){
                    logException(e);
                }

            }
        });
        System.out.println("loaded items : "+dao.loadAll());
        System.out.println("-- secound attempt ---");
    }

    private static void logException(Exception e) {
        System.out.println("-- exception message --");
        System.err.println("예외 처리한 클래스 ? : " +e.getClass());
        System.out.println("---------------------------------------------------");
    }
}
