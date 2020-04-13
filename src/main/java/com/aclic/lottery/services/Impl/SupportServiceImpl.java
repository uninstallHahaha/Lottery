package com.aclic.lottery.services.Impl;

import com.aclic.lottery.Models.Comment;
import com.aclic.lottery.Models.Support;
import com.aclic.lottery.Models.compound.SupportMNews;
import com.aclic.lottery.daos.CommentDao;
import com.aclic.lottery.daos.SupportDao;
import com.aclic.lottery.services.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SupportServiceImpl implements SupportService {

    @Autowired
    private SupportDao supportDao;


    @Override
    public List<Support> findAll() {
        return supportDao.findAll();
    }

    @Override
    public Support findOne(String id) {
        return supportDao.findOne(id);
    }

    @Override
    public int modSupport(Support support) {
        return supportDao.modSupport(support);
    }

    @Override
    public int addSupport(Support u) {
        return supportDao.addSupport(u);
    }

    @Override
    public int delSupport(String id) {
        return supportDao.delSupport(id);
    }

    @Override
    public List<Support> findSeriousByNews(String newsId) {
        return supportDao.findSeriousByNews(newsId);
    }

    @Override
    public List<Support> findSeriousByUser(String userId) {
        return supportDao.findSeriousByUser(userId);
    }

    @Override
    public List<SupportMNews> findSeriousMNewsByUser(String userId) {
        return supportDao.findSeriousMNewsByUser(userId);
    }
}
