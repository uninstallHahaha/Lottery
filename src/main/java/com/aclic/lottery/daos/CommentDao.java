package com.aclic.lottery.daos;

import com.aclic.lottery.Models.Comment;
import com.aclic.lottery.Models.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {

    @Select("select * from comment")
    public List<Comment> findAll();

    @Insert("insert into comment (id, newsid, userid, content) " +
            "values(#{id}, #{newsid}, #{userid}, #{content})")
    public int addComment(Comment comment);

    @Update("update comment set newsid=#{newsid},userid=#{userid},content=#{content} " +
            "where id=#{id}")
    public int modComment(Comment comment);

    @Delete("delete from comment where id=#{id}")
    public int delComment(String id);


    @Select("select * from comment where newsid=#{newsId}")
    List<Comment> findSerious(String newsId);
}
