package com.chen.service;

import com.chen.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    Boolean addUser(User user);

    Boolean deleteUser(int id) ;

    Boolean updateUser(User user) ;

    Boolean modifyPassword(int id, String password) ;

    List<User> findAllUser() ;

    User findUserById(int id) ;

    User login(String username,String password);
}
