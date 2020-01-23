package com.ac.controller.tax;

import io.swagger.annotations.Api;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author anchao
 * @date 2020/1/21 11:16
 */
@Api(value = "测试接口", tags = "测试接口")
@Controller
@RequestMapping("t")
public class TaxController {

    @GetMapping("list")
    public String list(){
        return "/tax/list";
    }

    @GetMapping("query")
    public String query(){
        return "/tax/query";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("add")
    public String add(){
        return "/tax/add";
    }

}
