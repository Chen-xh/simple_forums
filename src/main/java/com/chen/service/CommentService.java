package com.chen.service;

import com.chen.entity.*;

import java.util.List;

public interface CommentService {
    Boolean addComment(Comment comment) ;

    Boolean delete(int id) ;


    List<CommentDetail> findAllComment( int tid) ;

    Comment findById(int id) ;

    List<Comment> findByUid(int uid) ;

}
