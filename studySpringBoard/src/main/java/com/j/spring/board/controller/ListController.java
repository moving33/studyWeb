package com.j.spring.board.controller;

import com.j.spring.board.model.BoardVO;
import com.j.spring.board.model.Paging;
import com.j.spring.board.service.BoardListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


//게시판용 컨트롤러
@Controller
public class ListController {

    @Autowired
    private BoardListService boardListService;
    @Autowired
    private Paging paging;

    @RequestMapping("board/list.do")
    public ModelAndView modelAndView(@RequestParam(required = false) String pageNum,
                                     @RequestParam(required = false) String search_type,
                                     @RequestParam(required = false) String search_text){


        if(pageNum == null || pageNum =="") pageNum = "1";

        //현재페이지
        int currentPage = Integer.parseInt(pageNum);
        int pageSize = 10; //페이지당 보여줄 글
        int pageBlockSize = 5; // 페이지 블록의 사이즈

        //검색설정확인
        if(search_type == null)search_type="";
        if(search_text == null)search_text="";

        //service로 넘겨줄 map객체 생성
        Map<String,Object> map = new HashMap<>();
        map.put("search_type",search_type);
        map.put("search_text",search_text);

        //List 처리

        //전체 글수 or 검색하고자하는 글수
        int count = boardListService.getListCount(map);

        //List에 보여질 글번호
        int number = count-(currentPage-1)*pageSize;

        //페이징처리 설정
        paging.setPaging(pageSize,pageBlockSize,count,currentPage);
        //페이지에서 가져올 글 설정
        map.put("startRow",paging.getWriting_Start());
        map.put("endRow",paging.getWriting_End());
        System.out.println(paging.getWriting_Start()+"..."+paging.getWriting_End());

        //페이지에표시할 글 받아오기
        List<BoardVO> list = boardListService.getBoardList(map);


        //View에서 사용할 녀석들 넣기
        Map<String,Object> model = new HashMap<>();
        model.put("boardList",list);
        model.put("count",count);
        model.put("number",number); //List에 보여질 글버호
        model.put("search_text",search_text);
        model.put("search_type",search_type);
        model.put("pageNum",pageNum);
        model.put("bp",paging);

        //modelAndView 설정

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/board/list");
        modelAndView.addAllObjects(model);

        return modelAndView;
    }

















    public BoardListService getBoardListService() {
        return boardListService;
    }

    public void setBoardListService(BoardListService boardListService) {
        this.boardListService = boardListService;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
}
