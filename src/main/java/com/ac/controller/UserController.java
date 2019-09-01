package com.ac.controller;

import com.ac.model.User;
import com.ac.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author anchao
 *
 */
@Api("用户服务")
@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "获取用户所有信息", produces = "application/json")
    @GetMapping("/getUser")
    @ResponseBody
    public List<User> getUser(){
        return userService.queryUser();
    }

    @ApiOperation(value = "批量插入用户信息", produces = "application/json")
    @GetMapping("/batchSave")
    public void batchSave(){
        User u;
        for (int i = 0; i <5 ; i++) {
            u =new User();
            u.setName("an"+i);
            userService.batchSave(u);
        }
    }

    @ApiOperation(value = "获取某个用户信息", produces = "application/json")
    @GetMapping("/getUserInfo/{id}")
    public void getUserInfo(@PathVariable("id") Long id){

    }
}
