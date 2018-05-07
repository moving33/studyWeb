package com.j.spring.board.controller;

import com.j.spring.board.model.BoardVO;
import com.j.spring.board.service.DeleteArticleService;
import com.j.spring.board.service.GetArticleService;
import com.j.spring.board.service.ModifyArticleService;
import com.j.spring.board.service.comment.CommentListService;
import com.j.spring.board.service.comment.DeleteCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Controller
@SessionAttributes("vo")
public class GetArticleController {

    @Autowired
    private GetArticleService getArticleService;
    @Autowired
    private CommentListService commentListService;
    @Autowired
    private ModifyArticleService modifyArticleService;
    @Autowired
    private DeleteArticleService deleteArticleService;
    @Autowired
    private DeleteCommentService deleteCommentService;



    @RequestMapping(value = "board/modifyForm.do", method = RequestMethod.GET)
    public String setView(@ModelAttribute("vo")BoardVO vo, Model model) {

        /*BoardVO boardVO = modifyArticleService.getArticle(num);
        System.out.println(boardVO.toString());

        Map<String, Object> map = new HashMap<>();
        map.put("vo", boardVO);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/board/updateForm");
        modelAndView.addAllObjects(map);*/

        return "board/updateForm";
    }

    @RequestMapping(method = RequestMethod.POST , value = "board/modifyForm.do")
    public ModelAndView onSubmit(@ModelAttribute("vo") BoardVO boardVO, BindingResult bindingResult)throws Exception{

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
            modelAndView.setViewName("/board/content");
            modelAndView.addAllObjects(map);
            return modelAndView;
        }

    }

    @RequestMapping("board/content.do")
    public String getArticle(Integer num, Model model) {
        BoardVO boardVO = getArticleService.getArticle(num);
        model.addAttribute("vo", boardVO);
        model.addAttribute("commentCount", commentListService.getCommentListCount(num));

      /*  Map<String,Object> map = new HashMap<>();
        map.put("vo",boardVO); //가져온 객체 넣기

        //댓글 가져오기
        int commentCount = 0;
        commentCount = commentListService.getCommentListCount(num);
        map.put("commentCount",commentCount); //댓글 개수 얻기

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/board/content");

        modelAndView.addAllObjects(map);*/

        return "board/content";

    }

    @RequestMapping(value ="board/deleteForm.do" , method = RequestMethod.GET)
    public ModelAndView onSubmit(Integer num, @ModelAttribute("vo") BoardVO boardVO){
        String dbPass = deleteArticleService.getPass(num);
        if(boardVO.getPass().equals(dbPass)){
            deleteArticleService.deleteArticle(num);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/board/list.do");
            //modelAndView.addObject("num",num);
            modelAndView.addObject("value","successDelete");
            return modelAndView;
        }else{
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("board/content");
            modelAndView.addObject("num",num);
            modelAndView.addObject("value","passerror");
            return modelAndView;
        }
    }

    //글삭제 (비밀번호 확인)
    @RequestMapping(value="board/delete.do" , method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> confirmPasswd(@RequestBody Map<String,Object> params){
        System.out.println("aaaaaaaaaaaaaaaa");
        Integer number = (Integer) params.get("articleNum");
        System.out.println(number);
        String dbPass = deleteArticleService.getPass(number);
        System.out.println(dbPass);

        String userPass = (String) params.get("passwd");

        int result = 0;

        if(dbPass.equals(userPass)){
            result = 1;
        }

        Map<String,Object> map = new HashMap<>();
        map.put("result",result);
        return map;
    }

    //댓글삭제
    @RequestMapping(value = "comment/delete.do",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> deleteComment(@RequestBody Map<String,Object> params, HttpServletResponse resp) throws IOException {
        Integer comment_num = (Integer) params.get("commentNum");
        deleteCommentService.deleteComment(comment_num);
        Map<String,Object> map = new HashMap<>();
        map.put("result","success");
        return map;
    }

    public DeleteCommentService getDeleteCommentService() {
        return deleteCommentService;
    }

    public void setDeleteCommentService(DeleteCommentService deleteCommentService) {
        this.deleteCommentService = deleteCommentService;
    }

    public GetArticleService getGetArticleService() {
        return getArticleService;
    }

    public void setGetArticleService(GetArticleService getArticleService) {
        this.getArticleService = getArticleService;
    }

    public CommentListService getCommentListService() {
        return commentListService;
    }

    public void setCommentListService(CommentListService commentListService) {
        this.commentListService = commentListService;
    }

    public ModifyArticleService getModifyArticleService() {
        return modifyArticleService;
    }

    public void setModifyArticleService(ModifyArticleService modifyArticleService) {
        this.modifyArticleService = modifyArticleService;
    }

    public DeleteArticleService getDeleteArticleService() {
        return deleteArticleService;
    }

    public void setDeleteArticleService(DeleteArticleService deleteArticleService) {
        this.deleteArticleService = deleteArticleService;
    }
}
