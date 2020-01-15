package com.ac.controller;

import com.ac.common.utils.Constants;
import com.ac.mongo.MongoService;
import com.ac.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/** 用户服务
 * @author anchao
 *
 */
@Api(value = "用户服务",tags = "用户服务")
@Slf4j
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private MongoService mongoService;

    @Autowired
    private UserService userService;

    @ApiOperation("获取所有用户信息")
    @GetMapping(value = "getAll")
    @ResponseBody
    public List getAll(){
        return  userService.getAll();
    }


    @ApiOperation("点击页面跳转")
    @GetMapping("click")
    public ModelAndView click(ModelAndView modelAndView){
        modelAndView.setViewName("/one");
        modelAndView.addObject("cid",10);
        log.info("UserController.click.页面跳转......");
        return modelAndView;
    }


    @ApiOperation("测试mongo查询")
    @GetMapping(value = "mongoQ")
    @ResponseBody
    public List<Map> mongoQ(){
        Criteria criteria = new Criteria("bookName");
        String format = String.format(Constants.LIKE_CONTAINS, "2");
        criteria.regex(Pattern.compile(format));
        List<Map> user = mongoService.query(criteria, "user");
        return  user;
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
