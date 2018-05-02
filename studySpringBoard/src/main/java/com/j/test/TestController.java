package com.j.test;


import com.j.spring.board.dao.BoardDAO;
import com.j.spring.board.model.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestController {

    @Autowired
    private BoardDAO boardDAO;

    @RequestMapping("/test2/hello.do")
    public ModelAndView modelAndView(){
        if(boardDAO != null){
            System.out.println("성공");
        }
        boardDAO.insertArticle(new BoardVO());

        return null;
    }

}
