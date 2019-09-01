package com.ac.controller;

import com.ac.model.User;
import com.ac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author anchao
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 获取全部用户信息
     */
    @GetMapping("/getUser")
    @ResponseBody
    public List<User> getUser(){
        return userService.queryUser();
    }

    /**
     * 批量插入
     */
    @GetMapping("/batchSave")
    public void batchSave(){
        User u;
        for (int i = 0; i <5 ; i++) {
            u =new User();
            u.setName("an"+i);
            userService.batchSave(u);
        }
    }
}
