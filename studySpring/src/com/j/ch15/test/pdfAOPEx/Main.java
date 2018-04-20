package com.j.ch15.test.pdfAOPEx;

import com.j.ch15.board.service.WriteArticleService;
import com.j.ch15.member.service.MemberService;
import com.j.ch15.model.Article;
import com.j.ch15.model.Member;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] ar){
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("/com/j/ch15/xml/applicationContext.xml");

        WriteArticleService articleService = context.getBean("writeArticleService",WriteArticleService.class);
        articleService.write(new Article());

        MemberService memberService = context.getBean("memberService",MemberService.class);
        memberService.regist(new Member());


    }
}
