package com.j.spring.board.controller;


//글쓰기 컨트롤러

import com.j.spring.board.model.BoardVO;
import com.j.spring.board.service.WriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;


@Controller
public class WriteController {

    @Autowired
    private WriteService writeService;

    @RequestMapping(method = RequestMethod.GET , value = "board/writeForm.do")
    public ModelAndView viewWrite(){
        BoardVO boardVO = new BoardVO();
        ModelAndView modelAndView = new ModelAndView("board/writeForm");
        modelAndView.addObject(boardVO);
        return modelAndView;
    }


    @RequestMapping(method = RequestMethod.POST , value = "board/writeForm.do")
    public ModelAndView onSubmit(@ModelAttribute(value = "boardVO")BoardVO boardVO,
                                 BindingResult bindingResult){

      /*  if(result.hasErrors()){
            //에러페이지 보낼수 있음
            System.out.println("error");
            }*/
        System.out.println(boardVO.toString());
        writeService.insertWriting(boardVO);
        return new ModelAndView("redirect:/board/list.do");

    }



    public WriteService getWriteService() {
        return writeService;
    }

    public void setWriteService(WriteService writeService) {
        this.writeService = writeService;
    }
}
