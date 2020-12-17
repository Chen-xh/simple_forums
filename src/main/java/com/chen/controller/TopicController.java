package com.chen.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.chen.entity.PageBean;
import com.chen.entity.Topic;
import com.chen.entity.TopicDetail;
import com.chen.entity.User;
import com.chen.service.TopicService;
import com.chen.util.MyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: CHEN
 * @date: 2020-11-26 08:49
 **/
@Controller
public class TopicController {
    @Resource
    private TopicService topicService;

    @RequestMapping(value = "findAllTopic",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String findAllTopic(int page) {
        PageBean<TopicDetail> pageBean= topicService.findAllPage(page);

        return MyUtil.toJSONString("data",pageBean);
    }
    @RequestMapping(value = "findTopicByUid",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String findTopicByUid(int page,int uid) {
        PageBean<TopicDetail> pageBean= topicService.findByUid(page,uid);

        return MyUtil.toJSONString("data",pageBean);


    }

    @RequestMapping(value = "addTopic",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addTopic(Topic topic) {

        topicService.addTopic(topic);
        return MyUtil.toJSONString("data","success");
    }

    @RequestMapping(value = "deleteTopic",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String delete(int tid) {
        topicService.delete(tid);
        return MyUtil.toJSONString("data","success");
    }
}
