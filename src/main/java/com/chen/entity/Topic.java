package com.chen.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: CHEN
 * @date: 2020-11-19 15:26
 * Topic实体类
 **/
public class Topic  {
    private int tid;
    private String title;
    private String message;
    private int uid;

    @Override
    public String toString() {
        return "Topic{" +
                "tid=" + tid +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", uid=" + uid +
                '}';
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
