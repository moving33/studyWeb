package com.j.spring.board.controller;

import com.j.spring.board.model.BoardVO;
import com.j.spring.board.service.ModifyArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ModifyController {
    @Autowired
    private ModifyArticleService modifyArticleService;

   /* @RequestMapping(value="board/modifyForm.do",method = RequestMethod.GET)
    public ModelAndView setView(@RequestParam(value = "num") Integer num){

        BoardVO boardVO = modifyArticleService.getArticle(num);
        System.out.println(boardVO.toString());

        Map<String,Object> map = new HashMap<>();
        map.put("vo",boardVO);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/board/updateForm");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }*/

   /* @RequestMapping(method = RequestMethod.POST , value = "board/modifyForm.do")
    public ModelAndView onSubmit(@ModelAttribute(value="boardVO") BoardVO boardVO, BindingResult bindingResult)throws Exception{

        System.out.println("받아온 데이터 : " +boardVO.toString());
        String pass = modifyArticleService.getPass(boardVO.getNum());

        if(pass.equals(boardVO.getPass())){
            modifyArticleService.updateArticle(boardVO);
            return new ModelAndView("redirect:/board/list.do");
        }else{
            boardVO = modifyArticleService.getArticle(boardVO.getNum());
            Map<String,Object> map = new HashMap<>();
            map.put("vo",boardVO);
            String passerror = "pass";
            map.put("value",passerror);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("/board/updateForm");
            modelAndView.addAllObjects(map);
            return modelAndView;
        }

    }*/




    public ModifyArticleService getModifyArticleService() {
        return modifyArticleService;
    }

    public void setModifyArticleService(ModifyArticleService modifyArticleService) {
        this.modifyArticleService = modifyArticleService;
    }
}
