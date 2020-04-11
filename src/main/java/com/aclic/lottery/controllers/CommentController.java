package com.aclic.lottery.controllers;

import com.aclic.lottery.Models.Comment;
import com.aclic.lottery.Utils.Utils;
import com.aclic.lottery.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

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
    public int addComment(Comment comment){//
//        for(int i =0;i<20;i++){
//            Comment comment = new Comment(Utils.genUUID(),"05a90d9b-f45b-4fed-940c-2f50", "ssfe", "adfdsfjk");
//            commentService.addComment(comment);
//        }
        comment.setId(Utils.genUUID());
        int res = commentService.addComment(comment);
        return res;
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

    @ResponseBody
    @RequestMapping("/addAndReturnComment")
    public Map<String, Object> addAndReturnComment(Comment comment){
        comment.setId(Utils.genUUID());
        return commentService.addAndReturnComment(comment);
    }

}
