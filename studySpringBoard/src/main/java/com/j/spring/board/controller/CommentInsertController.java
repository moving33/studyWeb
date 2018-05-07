package com.j.spring.board.controller;

import com.j.spring.board.model.CommentVO;
import com.j.spring.board.service.comment.CommentInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CommentInsertController {

    @Autowired
    CommentInsertService commentInsertService;

    @RequestMapping(value = "/board/comment/{paramNum}/insert.do", method = RequestMethod.POST)
    public Map<String,Object> insertComment(@PathVariable(value = "paramNum") Integer num,
                                            @RequestBody CommentVO form) {

        form.setNum(num);
        System.out.println(form.toString());

        commentInsertService.insertComment(form);
        Map<String,Object> objectMap = new HashMap<>();
        int result = 1;
        objectMap.put("result",result);
        return objectMap;

    }

    public CommentInsertService getCommentInsertService() {
        return commentInsertService;
    }

    public void setCommentInsertService(CommentInsertService commentInsertService) {
        this.commentInsertService = commentInsertService;
    }
}
