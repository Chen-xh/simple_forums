package com.chen.service.impl;

import com.chen.dao.CommentDao;
import com.chen.entity.Comment;
import com.chen.entity.CommentDetail;
import com.chen.entity.Topic;
import com.chen.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: CHEN
 * @date: 2020-12-03 19:34
 **/
@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    CommentDao commentDao;

    @Override
    public Boolean addComment(Comment comment) {
        return commentDao.insertComment(comment);
    }

    @Override
    public Boolean delete(int id) {
        return commentDao.delete(id);
    }

    @Override
    public List<CommentDetail> findAllComment(int tid) {
        return commentDao.findByTid(tid);
    }

    @Override
    public Comment findById(int id) {
        return commentDao.findById(id);
    }

    @Override
    public List<Comment> findByUid(int uid) {
        return commentDao.findByUid(uid);
    }
}
