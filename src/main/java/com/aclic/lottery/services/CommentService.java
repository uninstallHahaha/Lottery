package com.aclic.lottery.services;

import com.aclic.lottery.Models.Comment;
import com.aclic.lottery.Models.User;

import java.util.List;

public interface CommentService {
    public List<Comment> findAll();
    public int addComment(Comment u);
    public int delComment(String id);
    public int modComment(Comment u);
}

