package com.chen.entity;


import java.io.Serializable;

/**
 * @author: CHEN
 * @date: 2020-11-19 15:26
 * Comment实体类
 **/
public class CommentDetail implements Serializable {
    private int cid;
    private String message;
    private int tid;
    private String username;
    private int age;
    private String phone;
    private String email;
    private String rode;

    @Override
    public String toString() {
        return "CommentDetail{" +
                "cid=" + cid +
                ", message='" + message + '\'' +
                ", tid=" + tid +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", rode='" + rode + '\'' +
                '}';
    }

    public CommentDetail() {
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

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRode() {
        return rode;
    }

    public void setRode(String rode) {
        this.rode = rode;
    }
}
