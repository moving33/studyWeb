package com.j.spring.controller.test;

import com.j.spring.board.dao.BoardDAO;
import com.j.spring.board.model.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
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

        Map<String,Object> map = new HashMap<String,Object>();
       // map.put("search_type","all");
        map.put("startRow",new Integer(1));
        map.put("endRow",new Integer(10));
        List<BoardVO> vo = boardDAO.getList(map);


        modelAndView.addObject("list",vo);
        //modelAndView.addObject("count",boardDAO.getListCount(map));
        return modelAndView;
    }
}
