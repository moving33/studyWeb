package com.j.spring.board.controller;

import com.j.spring.board.model.BoardVO;
import com.j.spring.board.service.GetArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


@Controller
public class GetArticleController {

    @Autowired
    private GetArticleService getArticleService;

    @RequestMapping("board/content.do")
    public ModelAndView getArticle(Integer num){
        BoardVO boardVO = getArticleService.getArticle(num);
        Map<String,Object> map = new HashMap<>();
        map.put("vo",boardVO);

        //댓글 가져오기
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/board/content");
        modelAndView.addAllObjects(map);
        return modelAndView;

    }



    public GetArticleService getGetArticleService() {
        return getArticleService;
    }

    public void setGetArticleService(GetArticleService getArticleService) {
        this.getArticleService = getArticleService;
    }
}
