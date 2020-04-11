package com.aclic.lottery.services.Impl;

import com.aclic.lottery.Models.Comment;
import com.aclic.lottery.daos.CommentDao;
import com.aclic.lottery.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comment> findAll() {
        List<Comment> commentList = commentDao.findAll();
        return commentList;
    }

    @Override
    public List<Comment> findSerious(String newsId) {
        return commentDao.findSerious(newsId);
    }

    @Override
    public int addComment(Comment u) {
        return commentDao.addComment(u);
    }

    @Override
    public int delComment(String id) {
        return commentDao.delComment(id);
    }

    @Override
    public int modComment(Comment comment) {
        return commentDao.modComment(comment);
    }
}
