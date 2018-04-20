//캐쉬 담당 advice

package com.j.ch15.aop;

import com.j.ch15.model.Article;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.HashMap;
import java.util.Map;

public class ArticleCacheAdvice {
    private Map<Integer,Article> cache = new HashMap<>();

    //aspect 에서 advice 사이에 넣을 cache 설정코드
    public Article cache(ProceedingJoinPoint joinPoint)throws Throwable{
        //실행되는 method에 0번 인자 = 첫번째 param값을 의미
        Integer id = (Integer)joinPoint.getArgs()[0];
        Article article = cache.get(id);

        //cache에 저장된 내용이 있을시
        if(article != null){
            System.out.println("[ArticleCacheAdvice] : cache 에서 Article ["+id+"] 반환.");
            return article;
        }
        //저장된 내용이 없으므로 메서드 수행
        System.out.println("around 실행전");
        /////////////////////////////////////////////////////////
        Article ret = (Article) joinPoint.proceed();
        System.out.println("원래 method 실행");
        /////////////////////////////////////////////////////
        System.out.println("around 실행후");
        if(ret != null){
            //수행한 article 저장
            cache.put(id,ret);
            System.out.println("[ArticleCacheAdvice] : cache 에서 Article ["+id+"] 저장.");
        }

        return ret;

    }

}
