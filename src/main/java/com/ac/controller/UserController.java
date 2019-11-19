package com.ac.controller;

import com.ac.model.User;
import com.ac.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/** 用户服务
 * @author anchao
 *
 */
@Api("用户服务")
@Controller
@RequestMapping("/user")
public class UserController {



    @Autowired
    private UserService userService;


    @GetMapping("/hi")
    @ResponseBody
    public String hi(){
        return "hi spring ~";
    }

    @ApiOperation(value = "获取用户所有信息", produces = "application/json")
    @GetMapping("/getUser")
    @ResponseBody
    public List<User> getUser(){
        return userService.list();
    }

    @ApiOperation(value = "插入用户信息", produces = "application/json")
    @PostMapping("/save")
    public void save(@RequestBody User user){
            userService.save(user);
    }

    @ApiOperation(value = "获取某个用户信息", produces = "application/json")
    @GetMapping("/getUserInfo/{id}")
    @ResponseBody
    public User getUserInfo(@PathVariable("id") Long id){
        return userService.getById(id);
    }
}
