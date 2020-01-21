package com.ac.controller.poi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;

/**
 * @author anchao
 * @date 2019/11/19 16:18
 */
@ApiIgnore
@Controller
public class EasyPoiController {



    @GetMapping("/e")
    public void test1(HttpServletResponse response){
       // EasyPoiUtil.exportExcel(list,"sheet_test", User.class,"用户信息.xls",response);
    }

}
