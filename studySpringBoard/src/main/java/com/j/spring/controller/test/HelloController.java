package com.j.spring.controller.test;

import com.j.spring.board.dao.BoardDAO;
import com.j.spring.board.model.BoardVO;
import com.j.test.TestClass;
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

    @Autowired
    private TestClass testClass;

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
        Map<String,Object> map2 = new HashMap<>();

        map2.put("startRow",new Integer(1));
        map2.put("endRow",new Integer(2));
        map2.put("search_type","writer");
        map2.put("search_text","태형형님");
        List<BoardVO> r = boardDAO.getList(map2);

        modelAndView.addObject("test",testClass.getTEST());
        modelAndView.addObject("list",r);
        return modelAndView;
    }
}
