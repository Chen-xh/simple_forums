package com.chen.service;

import com.chen.entity.PageBean;
import com.chen.entity.Topic;
import com.chen.entity.TopicDetail;
import com.chen.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface TopicService {
    Boolean addTopic(Topic topic) ;

    Boolean delete(int id) ;


    List<Topic> findAllTopic() ;

    Topic findById(int id) ;

    PageBean<TopicDetail> findAllPage(int page) ;

    PageBean<TopicDetail> findByUid(int page,int uid) ;
}
