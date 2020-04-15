package com.aclic.lottery.daos;

import com.aclic.lottery.Models.News;
import com.aclic.lottery.Models.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsDao {

    @Select("select * from news ORDER BY createtime DESC")
    public List<News> findAll();

    @Select("select * from news where state=0 ORDER BY createtime DESC")
    public List<News> findAllScrs();

    @Select("select * from news where state=1 ORDER BY zan DESC limit 10")
    public List<News> findTopNews();

    @Select("select * from news where id=#{id}")
    public News findOne(String id);

    @Insert("insert into news (id, title, content, zan, state ) " +
            "values(#{id},#{title},#{content},#{zan},#{state})")
    public int addUser(News news);

    @Update("update news set title=#{title},content=#{content},zan=#{zan} where id=#{id}")
    public int updateUser(News news);

    @Delete("delete from news where id=#{id}")
    public int delUser(String id);


    //业务
    //懒加载10
    @Select("select * from news where state=1 limit #{start},10")
    List<News> lazyGetNews(int start);
}
