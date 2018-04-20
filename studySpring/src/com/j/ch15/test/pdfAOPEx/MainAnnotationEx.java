package com.j.ch15.test.pdfAOPEx;

import com.j.ch15.board.service.ArticleNotFoundException;
import com.j.ch15.board.service.ReadArticleService;
import com.j.ch15.member.service.MemberService;
import com.j.ch15.member.service.UpdateInfo;
import com.j.ch15.model.Article;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAnnotationEx {
    @SuppressWarnings("Duplicates")
   public static void main(String[] ar){
       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/com/j/ch15/xml/applicationContextAnnotation.xml");
       ReadArticleService readArticleService = context.getBean("readArticleService",ReadArticleService.class);


       try {

           Article article1 = readArticleService.getArticleAndIncreaseReadCount(2);
           Article article2 = readArticleService.getArticleAndIncreaseReadCount(2);
           //해당 article 객체가 같은지 비쿄
           System.out.println("article == article :" + (article1 == article2));

           //Exception을 발생시키는 코드
           readArticleService.getArticleAndIncreaseReadCount(0);

       } catch (ArticleNotFoundException e) {
       }


       MemberService memberService = context.getBean("memberService", MemberService.class);
       //member를 추가
       memberService.update("javaLine2", new UpdateInfo());
   }
}
