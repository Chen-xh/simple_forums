package com.chen.controller;

import com.chen.entity.*;
import com.chen.service.CommentService;
import com.chen.service.TopicService;
import com.chen.util.MyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: CHEN
 * @date: 2020-11-26 08:49
 **/
@Controller
public class CommentController {
    @Resource
    private CommentService commentService;

    @RequestMapping(value = "findAllComment", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String findAllTopic(int tid) {

        List<CommentDetail> list = commentService.findAllComment(tid);
        return MyUtil.toJSONString("data", list);
    }

    @RequestMapping(value = "findCommentByUid", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String findCommentByUid(int uid) {
        List<Comment> list = commentService.findByUid(uid);

        return MyUtil.toJSONString("data", list);


    }

    @RequestMapping(value = "addComment", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addTopic(Comment comment) {
        commentService.addComment(comment);
        return MyUtil.toJSONString("data", "success");
    }

    @RequestMapping(value = "deleteComment",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String delete(int cid) {
        commentService.delete(cid);
        return MyUtil.toJSONString("data","success");
    }
}
