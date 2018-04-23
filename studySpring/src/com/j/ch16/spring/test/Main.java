package com.j.ch16.spring.test;

import com.j.ch16.spring.dao.GuestMessageDao;
import com.j.ch16.spring.model.GuestMessage;
import com.j.ch16.spring.service.MethodImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.util.List;

public class Main {

    //약식을위한 GuestMsg 생성
    private GuestMessage makeGuestMessage(String guestname,String message){
        GuestMessage msg = new GuestMessage();
        msg.setGuestName(guestname);
        msg.setMessage(message);
        msg.setRegdate(new Date(System.currentTimeMillis()));
        return msg;
    }

    public static void main(String[] ar){

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/com/j/ch16/spring/tt.xml");
        MethodImpl bean = (MethodImpl) context.getBean("methodImpl");
        GuestMessageDao dao = (GuestMessageDao) context.getBean("jdbcTemplateGuestMessageDao");
        bean.test();
        Main main = new Main();
        dao.insert(main.makeGuestMessage("J","첫번째 입니다!!"));
        dao.insert(main.makeGuestMessage("J","첫번째 입니다!!"));
        dao.insert(main.makeGuestMessage("J2","두번째 입니다!!"));
        dao.insert(main.makeGuestMessage("J3","세번째 입니다!!"));

        int count = dao.count();
        System.out.println("전체 글수 : "+count);
        List<GuestMessage> list = dao.select(1,count);
        for(GuestMessage msg : list){
            System.out.println(msg.toString());
        }

        GuestMessage msg = new GuestMessage();
        msg.setId(18);
        msg.setGuestName("J");
        msg.setMessage("message 수정본");
        msg.setRegdate(new Date(System.currentTimeMillis()));
        System.out.println("--------------------------------\n수정결과..");


        dao.update(msg);
        list = dao.select(1,count);
        for(GuestMessage msg2 : list){
            System.out.println(msg2.toString());
        }

        dao.delete(1);
        System.out.println("1번 id 삭제..");

        list = dao.select(1,count);

        for(GuestMessage msg2 : list){
            System.out.println(msg2.toString());
        }
    }
}
