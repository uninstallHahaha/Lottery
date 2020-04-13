package com.aclic.lottery.services;

import com.aclic.lottery.Models.Comment;
import com.aclic.lottery.Models.User;
import com.aclic.lottery.Models.compound.CommentMNews;
import com.aclic.lottery.Models.compound.CommentMUser;

import java.util.List;
import java.util.Map;

public interface CommentService {
    public List<Comment> findAll();

    public Comment findOne(String id);

    public List<Comment> findSerious(String newsId);

    public int addComment(Comment u);

    public int delComment(String id);

    public int modComment(Comment u);

    //add and get return
    public Map<String, Object> addAndReturnComment(Comment u);

    List<Comment> findSeriousByUser(String userId);

    List<CommentMNews> findSeriousMNewsByUser(String userId);

    List<CommentMUser> findSeriousMUserByNews(String userId);
}
