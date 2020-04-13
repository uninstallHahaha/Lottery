package com.aclic.lottery.services;

import com.aclic.lottery.Models.Comment;
import com.aclic.lottery.Models.Support;
import com.aclic.lottery.Models.compound.SupportMNews;

import java.util.List;
import java.util.Map;

public interface SupportService {
    public List<Support> findAll();

    public Support findOne(String id);

    public int modSupport(Support support);

    public int addSupport(Support u);

    public int delSupport(String id);

    List<Support> findSeriousByNews(String newsId);

    List<Support> findSeriousByUser(String userId);

    List<SupportMNews> findSeriousMNewsByUser(String userId);
}
