package com.ac.controller;

import com.ac.model.User;
import com.ac.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/** 用户服务
 * @author anchao
 *
 */
@Api(value = "用户服务",tags = "用户服务")
@Controller
@RequestMapping("/user")
public class UserController {



    @Autowired
    private UserService userService;


    @GetMapping("/getAll")
    @ResponseBody
    public List<User> getAll(){
        return  userService.getAll();
    }















//    @ApiOperation(value = "获取用户所有信息")
//    @GetMapping("/getUser")
//    @ResponseBody
//    public List<User> getUser(){
//        return userService.list();
//    }
//
//    @ApiOperation(value = "插入用户信息", produces = "application/json")
//    @PostMapping("/save")
//    public void save(@RequestBody User user){
//            userService.save(user);
//    }
//
//    @ApiOperation(value = "获取某个用户信息", produces = "application/json")
//    @GetMapping("/getUserInfo/{id}")
//    @ResponseBody
//    public User getUserInfo(@PathVariable("id") Long id){
//        return userService.getById(id);
//    }
//
//
//    @PostMapping(value = "/in",headers = MediaType.ALL_VALUE)
//    @ResponseBody
//    public String in(@RequestBody User user){
//        System.out.println(user);
//        return "hi spring ~";
//    }

}
