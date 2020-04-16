package com.aclic.lottery.daos;

import com.aclic.lottery.Models.Comment;
import com.aclic.lottery.Models.User;
import com.aclic.lottery.Models.compound.CommentMNews;
import com.aclic.lottery.Models.compound.CommentMUser;
import com.aclic.lottery.Models.compound.SupportMNews;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {

    @Select("select * from comment order by createtime DESC")
    public List<Comment> findAll();

    @Select("select * from comment where id=#{id}")
    public Comment findOne(String id);

    @Insert("insert into comment (id, newsid, userid, content) " +
            "values(#{id}, #{newsid}, #{userid}, #{content})")
    public int addComment(Comment comment);

    @Update("update comment set newsid=#{newsid},userid=#{userid},content=#{content} " +
            "where id=#{id}")
    public int modComment(Comment comment);

    @Delete("delete from comment where id=#{id}")
    public int delComment(String id);


    @Select("select * from comment where newsid=#{newsId} order by createtime DESC")
    List<Comment> findSerious(String newsId);

    @Select("select * from comment where userid=#{userId} order by createtime DESC")
    List<Comment> findSeriousByUser(String userId);

    //comment mix news by user
    @Select("SELECT comment.*,news.title FROM `comment`,`news` where " +
            "comment.newsid=news.id and comment.userid=#{userId}")
    List<CommentMNews> findSeriousMNewsByUser(String userId);

    //comment mix user by news
    @Select("SELECT comment.*,user.account,user.av FROM `comment`,`user` where " +
            "comment.userid=user.id and comment.newsid=#{userId}")
    List<CommentMUser> findSeriousMUserByNews(String userId);
}
