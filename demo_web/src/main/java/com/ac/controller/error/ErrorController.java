package com.ac.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author anchao
 * @date 2020/1/21 13:14
 */
@ApiIgnore
@Controller
public class ErrorController {


    @GetMapping("403")
    public String list(){
        return "/403";
    }

}
