package com.j.spring.controller.test;

import com.j.spring.board.dao.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class HelloController {

    @Autowired
    private BoardDAO boardDAO;

    @RequestMapping("/hello")
    public ModelAndView helloSpring(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test/hello");
        modelAndView.addObject("test","마마마마마마마마");
        modelAndView.addObject("count",boardDAO.getListCount());
        return modelAndView;
    }
}
