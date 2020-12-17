package com.chen.entity;

/**
 * @author: CHEN
 * @date: 2020-12-04 16:00
 **/
public class TopicDetail {
    private int tid;
    private String title;
    private String message;
    private String username;
    private int age;
    private String phone;
    private String email;
    private String rode;

    @Override
    public String toString() {
        return "TopicDetail{" +
                "tid=" + tid +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", rode='" + rode + '\'' +
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
