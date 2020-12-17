package com.chen.dao;

import com.chen.entity.Comment;
import com.chen.entity.CommentDetail;
import com.chen.entity.Topic;
import com.chen.entity.TopicDetail;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: CHEN
 * @date: 2020-11-19 15:34
 **/
@Mapper
public interface CommentDao {
    @Insert("insert into `comment`(message,uid,tid) values( #{message}  , #{uid} , #{tid})")
    boolean insertComment(Comment comment) ;

    @Delete("DELETE FROM `comment` WHERE cid=#{id}")
    boolean delete(int id) ;


    @Select("SELECT * FROM comment c left outer join `user` u on(c.uid=u.id) where tid=#{tid}")
    List<CommentDetail> findByTid(int tid) ;

    @Select("SELECT * FROM `comment` WHERE cid=#{id}")
    Comment findById(int id);

    @Select("SELECT * FROM comment c left outer join `user` u on(c.uid=u.id)")
    List<CommentDetail> findAll() ;

    @Select("SELECT * FROM comment  WHERE uid=#{uid}")
    List<Comment> findByUid(@Param("uid")int uid) ;
}
