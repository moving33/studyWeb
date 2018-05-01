package com.j.spring.controller.test;

import com.j.spring.board.dao.BoardDAO;
import com.j.spring.board.model.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String,Object> map = new HashMap<>();
        map.put("search_type","writer");
        map.put("search_text","moving33");
        modelAndView.addObject("count",boardDAO.getListCount(map));
        //getListTest

        //todo mapType의 Integer값을 넣었지만 board.xml에서 mapping된 #{startRow}를 인식못함..
        //18...parameter를 안주고 있었네요.. ?? 실화냐?
        Map<String,Object> map2 = new HashMap<>();

        map2.put("startRow",new Integer(1));
        map2.put("endRow",new Integer(2));

        List<BoardVO> r = boardDAO.getList(map2);
        if(r.isEmpty())System.out.println("...");

        modelAndView.addObject("list",r);
        return modelAndView;
    }
}
