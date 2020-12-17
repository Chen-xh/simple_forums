package com.chen.dao;

import com.chen.entity.User;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: CHEN
 * @date: 2020-11-19 15:34
 **/
@Mapper
public interface UserDao {
    @Insert("insert into `user`(username,password,phone,email,age,rode) values( #{username} ,#{password} , #{phone} , #{email} ,#{age} , #{rode} )")
    boolean insertUser(User user);

    @Delete("DELETE FROM `user` WHERE id=#{id}")
    boolean deleteUser(int id) ;

    @Update("UPDATE `user` SET username=#{username},password=#{password},phone=#{phone},email=#{email},age=#{age},rode=#{rode} WHERE id=#{id}")
    boolean updateUser(User user) ;

    @Update("UPDATE `user` SET password=#{password} WHERE id= #{id}")
    boolean modifyPassword(int id, String password) ;

    @Select("select * from user")
    List<User> findAllUser();

    @Select("SELECT * FROM `user` WHERE id=#{id}")
    User findUserById(int id);

    @Select("SELECT * FROM `user` WHERE username=#{username}")
    User findUserByUsername(String username) ;

}
