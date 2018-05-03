package com.j.spring.board.controller;

import com.j.spring.board.model.BoardVO;
import com.j.spring.board.service.DeleteArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeleteArticleController {

    @Autowired
    private DeleteArticleService deleteArticleService;

    @RequestMapping("board/deleteForm.do")
    public ModelAndView setView(Integer num){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/board/deleteForm");
        modelAndView.addObject("num",num);
        return modelAndView;
    }

    @RequestMapping(value ="board/deleteForm.do" , method = RequestMethod.POST)
    public ModelAndView onSubmit(Integer num, BoardVO boardVO){
        String dbPass = deleteArticleService.getPass(num);
        if(boardVO.getPass().equals(dbPass)){
            deleteArticleService.deleteArticle(num);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("/board/deleteForm");
            modelAndView.addObject("num",num);
            modelAndView.addObject("value","successDelete");
            return modelAndView;
        }else{
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("/board/deleteForm");
            modelAndView.addObject("num",num);
            modelAndView.addObject("value","passerror");
            return modelAndView;
        }
    }


    public DeleteArticleService getDeleteArticleService() {
        return deleteArticleService;
    }

    public void setDeleteArticleService(DeleteArticleService deleteArticleService) {
        this.deleteArticleService = deleteArticleService;
    }
}
