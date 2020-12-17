package com.chen.dao;

import com.chen.entity.Topic;
import com.chen.entity.TopicDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: CHEN
 * @date: 2020-11-19 15:34
 **/
@Mapper
public interface TopicDao {
    @Insert("insert into `topic`(title,message,uid) values( #{title} ,#{message} , #{uid})")
    boolean insertTopic(Topic topic) ;

    @Delete("DELETE FROM `topic` WHERE tid=#{id}")
    boolean delete(int id) ;


    @Select("select * from topic")
    List<Topic> findAllTopic() ;

    @Select("SELECT * FROM `topic` WHERE tid=#{id}")
    Topic findById(int id) ;

    @Select("SELECT * FROM topic t left outer join `user` u on(t.uid=u.id) " +
            "LIMIT #{start},#{end}")
    List<TopicDetail> findAllPage(@Param("start")int start,@Param("end")int end) ;

    @Select("SELECT * FROM topic  WHERE uid=#{uid} LIMIT #{start},#{end}")
    List<TopicDetail> findByUid(@Param("start")int start,@Param("end")int end,@Param("uid")int uid) ;

    @Select("SELECT COUNT(*) FROM topic")
    int getCount() ;

    @Select("SELECT COUNT(*) FROM topic where uid=#{uid}")
    int getCount2(int uid) ;
}
