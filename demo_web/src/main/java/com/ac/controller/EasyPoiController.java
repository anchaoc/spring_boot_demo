package com.ac.controller;

import com.ac.model.User;
import com.ac.service.UserService;
import com.ac.utils.EasyPoiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author anchao
 * @date 2019/11/19 16:18
 */
@Controller
public class EasyPoiController {

    @Autowired
    private UserService userService;


    @GetMapping("/e")
    public void test1(HttpServletResponse response){
        List<User> list = userService.list();
        EasyPoiUtil.exportExcel(list,"sheet_test", User.class,"用户信息.xls",response);
    }

}
