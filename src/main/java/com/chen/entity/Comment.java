package com.chen.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * @author: CHEN
 * @date: 2020-11-19 15:26
 * Comment实体类
 **/
public class Comment implements Serializable {
    private int cid;
    private String message;
    private int uid;
    private int tid;

    @Override
    public String toString() {
        return "Comment{" +
                "cid=" + cid +
                ", message='" + message + '\'' +
                ", uid=" + uid +
                ", tid=" + tid +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }
}
