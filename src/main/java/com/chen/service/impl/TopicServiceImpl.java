package com.chen.service.impl;

import com.chen.dao.TopicDao;
import com.chen.entity.PageBean;
import com.chen.entity.Topic;
import com.chen.entity.TopicDetail;
import com.chen.service.TopicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: CHEN
 * @date: 2020-12-03 19:34
 **/
@Service
public class TopicServiceImpl implements TopicService {
    @Resource
    TopicDao topicDao;

    @Override
    public Boolean addTopic(Topic topic) {
        return topicDao.insertTopic(topic);
    }

    @Override
    public Boolean delete(int id) {
        return topicDao.delete(id);
    }

    @Override
    public List<Topic> findAllTopic() {
        return topicDao.findAllTopic();
    }

    @Override
    public Topic findById(int id) {
        return topicDao.findById(id);
    }

    @Override
    public PageBean<TopicDetail> findAllPage(int page) {
        int size=5;
        int start=(page-1)*size;
        int end=page*size;
        int totalSize=topicDao.getCount();
        PageBean<TopicDetail> pageBean=new PageBean<>();
        pageBean.setList(topicDao.findAllPage(start,end));
        pageBean.setCurrentPage(page);
        pageBean.setPageSize(size);
        pageBean.setTotalSize(totalSize);
        pageBean.setTotalPage(totalSize/size+1);
        return pageBean;
    }

    @Override
    public PageBean<TopicDetail> findByUid(int page,int uid) {
        int size=5;
        int start=(page-1)*size;
        int end=page*size;
        int totalSize=topicDao.getCount2(uid);
        PageBean<TopicDetail> pageBean=new PageBean<>();
        pageBean.setList(topicDao.findByUid(start,end,uid));
        pageBean.setCurrentPage(page);
        pageBean.setPageSize(size);
        pageBean.setTotalSize(totalSize);
        pageBean.setTotalPage(totalSize/size+1);
        return pageBean;
    }
}
