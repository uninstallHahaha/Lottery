package com.aclic.lottery.daos;

import com.aclic.lottery.Models.Comment;
import com.aclic.lottery.Models.Support;
import com.aclic.lottery.Models.compound.SupportMNews;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupportDao {

    @Select("select * from support order by createtime DESC")
    public List<Support> findAll();

    @Select("select * from support where id=#{id}")
    public Support findOne(String id);

    @Insert("insert into support (id, newsid, userid) " +
            "values(#{id}, #{newsid}, #{userid})")
    public int addSupport(Support support);

    @Delete("delete from support where id=#{id}")
    public int delSupport(String id);

    @Update("update support set newsid=#{newsid},userid=#{userid} " +
            "where id=#{id}")
    public int modSupport(Support u);

    @Select("select * from support where newsid=#{newsId} order by createtime DESC")
    List<Support> findSeriousByNews(String newsId);

    @Select("select * from support where userid=#{userId} order by createtime DESC")
    List<Support> findSeriousByUser(String userId);

    //supprot mix news by user
    @Select("SELECT support.*,news.title FROM `support`,`news` where " +
            "support.newsid=news.id and support.userid=#{userId}")
    List<SupportMNews> findSeriousMNewsByUser(String userId);

}
