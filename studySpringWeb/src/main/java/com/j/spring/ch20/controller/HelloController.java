package com.j.spring.ch20.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class HelloController {

    @RequestMapping("/ch20/hello.do")
    public ModelAndView hello(){
        ModelAndView modelAndView = new ModelAndView();
        //view 에서 보여질 Page 의 name (ex : hello.jsp )
        modelAndView.setViewName("hello");
        modelAndView.addObject("greeting","Hello Spring MVC WEB");
        return modelAndView;
    }
}
