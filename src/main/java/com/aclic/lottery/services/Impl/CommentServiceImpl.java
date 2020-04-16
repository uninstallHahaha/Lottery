package com.aclic.lottery.services.Impl;

import com.aclic.lottery.Models.Comment;
import com.aclic.lottery.Models.User;
import com.aclic.lottery.Models.compound.CommentMNews;
import com.aclic.lottery.Models.compound.CommentMUser;
import com.aclic.lottery.daos.CommentDao;
import com.aclic.lottery.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Comment findOne(String id) {
        return commentDao.findOne(id);
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

    @Override
    public Map<String, Object> addAndReturnComment(Comment u , HttpSession session) {
        Map<String,Object> resMap = new HashMap<String,Object>();
        int res = commentDao.addComment(u);
        if (res == 1) {
            resMap.put("res", 1);
            Comment one = this.findOne(u.getId());
            CommentMUser commentMUser = new CommentMUser(
                    one.getId(),
                    one.getNewsid(),
                    one.getUserid(),
                    one.getContent(),
                    one.getCreatetime(),
                    ((User) session.getAttribute("USER_SESSION")).getAccount(),
                    ((User) session.getAttribute("USER_SESSION")).getAv()
            );
            resMap.put("obj", commentMUser);
        } else {
            resMap.put("res", 0);
            resMap.put("obj", null);
        }
        return resMap;
    }

    @Override
    public List<Comment> findSeriousByUser(String userId) {
        return commentDao.findSeriousByUser(userId);
    }

    @Override
    public List<CommentMNews> findSeriousMNewsByUser(String userId) {
        return commentDao.findSeriousMNewsByUser(userId);
    }

    @Override
    public List<CommentMUser> findSeriousMUserByNews(String newsId) {
        return commentDao.findSeriousMUserByNews(newsId);
    }

}
