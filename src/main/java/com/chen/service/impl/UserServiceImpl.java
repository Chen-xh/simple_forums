package com.chen.service.impl;

import com.chen.dao.UserDao;
import com.chen.entity.User;
import com.chen.exception.MyException;
import com.chen.service.UserService;
import com.chen.util.LogUtil;
import com.chen.exception.MyErrorCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: CHEN
 * @date: 2020-11-19 15:37
 **/
@Service
public class UserServiceImpl  implements UserService {
    @Resource
    UserDao userDao;

    @Override
    @LogUtil
    public Boolean addUser(User user)  {
        return userDao.insertUser(user);
    }

    @Override
    @LogUtil
    public Boolean deleteUser(int id)  {
        return userDao.deleteUser(id);
    }

    @Override
    @LogUtil
    public Boolean updateUser(User user)  {
        User old=userDao.findUserById(user.getId());
        //判断用户是否存在
        if(old==null){
            throw new MyException(MyErrorCode.NOT_FOND_USER);
        }
        old.setRode(user.getRode());
        old.setPhone(user.getPhone());
        old.setAge(user.getAge());
        old.setUsername(user.getUsername());
        old.setEmail(user.getEmail());
        return userDao.updateUser(old);
    }

    @Override
    public Boolean modifyPassword(int id, String password) {
        return userDao.modifyPassword(id,password);
    }

    @Override
    @LogUtil
    public List<User> findAllUser(){
        return userDao.findAllUser();
    }

    @Override
    @LogUtil
    public User findUserById(int id)  {
        return userDao.findUserById(id);
    }

    @Override
    public User login(String username, String password) {
        User user=userDao.findUserByUsername(username);
        //判断用户是否存在
        if(user==null){
            throw new MyException(MyErrorCode.NOT_FOND_USER);
        }
        //判断密码是否正确
        if(!user.getPassword().equals(password)) {
            throw new MyException(MyErrorCode.NO_ALLOW_LOGIN);
        }
        return user;
    }
}
