package com.aclic.lottery.controllers;

import com.aclic.lottery.Models.Comment;
import com.aclic.lottery.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Aclic
 */
@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    @ResponseBody
    @RequestMapping("/getComments")
    public List<Comment> findAll(){
        return commentService.findAll();
    }
    @ResponseBody
    @RequestMapping("/addComment")
    public int addComment(Comment u){//
        Comment comment = new Comment("xxeej","sss", "ssfe", "adfdsfjk");
        return commentService.addComment(comment);
    }
    @ResponseBody
    @RequestMapping("delComment")
    public int delComment(String id){//
        return commentService.delComment("sss");
    }
    @ResponseBody
    @RequestMapping("/modComment")
    public int modComment(Comment u){//
        Comment comment = new Comment("sss","sss", "ssfe", "adfdsfjk");
        return commentService.modComment(comment);
    }

}
