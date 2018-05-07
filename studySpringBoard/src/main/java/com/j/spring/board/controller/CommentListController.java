package com.j.spring.board.controller;

import com.j.spring.board.model.CommentVO;
import com.j.spring.board.model.Paging;
import com.j.spring.board.service.comment.CommentListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CommentListController {

    @Autowired
    private CommentListService commentListService;

    @Autowired
    private Paging paging;


    @RequestMapping(value = "/board/comment/{paramNum}",
                    method = RequestMethod.POST)
    public Map<String,Object> commentList(@PathVariable("paramNum") Integer num, String commentPageNum){

        //값이 없으면 1로 고정
        if(commentPageNum == null || commentPageNum == "") commentPageNum = "1";

        //현재코멘트 페이지
        int currentPage = Integer.parseInt(commentPageNum);
        int pageSize = 10; //페이지당 보여줄 댓글
        int pageBlockSize = 5; // 페이지 블록의 사이즈

        System.out.println(num);

        //해당글의 코멘트수
        int count = commentListService.getCommentListCount(num);
        System.out.println("해당게시글의 댓글수"+count);
        if(count == 0){

            return null;
        }
        //페이징처리 설정 사이즈,블럭사이즈,총개수,현재페이지
        paging.setPaging(pageSize,pageBlockSize,count,currentPage);

        Map<String,Object> map = new HashMap<>();
        //가져올코멘트녀석들설정
        map.put("startRow",paging.getWriting_Start());
        map.put("endRow",paging.getWriting_End());

        //표시할 페이지 받아오기  AJax에서 처리함
        List<CommentVO> list = commentListService.getCommentList(map);

        for(CommentVO vo:list){
            System.out.println(vo.toString());
        }

        //json에 넘길 값들 설정
        Map<String,Object> objectMap = new HashMap<>();

        map.put("list",list);
        map.put("count",count);
        map.put("paging",paging);
        map.put("commentPageNum",currentPage);

        System.out.println("dddddddddddd");
        return objectMap;
    }
}
