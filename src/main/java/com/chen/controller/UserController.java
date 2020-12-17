package com.chen.controller;

import com.chen.entity.User;
import com.chen.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: CHEN
 * @date: 2020-11-26 08:49
 **/
@Controller
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("login")
    public String login(String username, String password,HttpServletRequest request) {
        User user=userService.login(username, password);

        HttpSession session= request.getSession();
        session.setAttribute("user",user);
        return "index";
    }

    /**
     * 退出
     * @param request
     */
    @RequestMapping("exit")
    public String exit(HttpServletRequest request)  {
        HttpSession session= request.getSession();
        session.removeAttribute("user");
        return "index";
    }
    /**
     * 用户注册
     * @param user
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "regedit",method = RequestMethod.POST)
    public String regedit(User user,HttpServletRequest request) {
        user.setPassword(user.getPassword().trim());
        userService.addUser(user);
        System.out.println(user.toString());
        return "login";
    }
    /**
     * 用户修改
     * @param user
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "modify",method = RequestMethod.POST)
    public String modify(User user,HttpServletRequest request) {

        userService.updateUser(user);
        System.out.println(user.toString());
        HttpSession session= request.getSession();
        session.setAttribute("user",user);
        return "user";
    }
    /**
     * 修改密码前的确认密码
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("checkPassword")
    public String checkPassword(String username, String password,HttpServletRequest request)  {

        User user=userService.login(username, password);

        HttpSession session= request.getSession();
        session.setAttribute("user",user);
        return "modifyPassword2";
    }

    /**
     * 修改密码
     * @param id
     * @param password
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("modifyPassword")
    public void modifyPassword(int  id, String password,HttpServletRequest request) {
        password=password.trim();
       userService.modifyPassword(id, password);
        HttpSession session= request.getSession();
        session.removeAttribute("user");
    }
}
