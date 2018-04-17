package com.j.ch13;

import com.j.ch13.dao.UserDAO;
import com.j.ch13.model.CountingConnectionMaker;
import com.j.ch13.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import javax.sql.DataSource;
import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] ar) throws SQLException, ClassNotFoundException {
        //applicationContext.xml 로딩
        ApplicationContext context = new GenericXmlApplicationContext("/com/j/ch13/applicationContext.xml");
        System.out.println("applicationContext.xml File Loading end...");

        //로딩한 xml 에서 정의 되어있는 Bean객체 불러오기 getBean(" 정의한 id " , "반환할 Class Type")
        UserDAO userDAO = context.getBean("userDAO", UserDAO.class);
        User userOne = new User("TEST10","J","1234");
        userDAO.add(userOne);
        System.out.println(userOne.getId()+" 등록 성공...");

        userDAO.setDataSource(context.getBean("dataSource",DataSource.class));
        User userTwo = userDAO.get("TEST");
        System.out.println("검색한 결과: "+userTwo.getId()+" "+userTwo.getPass()+" "+userTwo.getName());

        CountingConnectionMaker ccm = context.getBean("countingConnectionMaker",CountingConnectionMaker.class);
        System.out.println("Connecting counter : "+ccm.getCount());
    }
}
