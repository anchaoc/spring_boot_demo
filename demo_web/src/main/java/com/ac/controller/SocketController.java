package com.ac.controller;

import com.ac.config.socket.server.WebSocketServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @author anchao
 * @date 2020/1/5 14:41
 */
@Controller
public class SocketController {

    /**
     */
    @GetMapping("/socket/{cid}")
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("one");
        mav.addObject("cid", cid);
        return mav;
    }


    /**
     * 推送数据接口
     */
    @ResponseBody
    @RequestMapping("/socket/push/{cid}")
    public  String pushToWeb(@PathVariable String cid,String message) {
        try {
            WebSocketServer.sendInfo(message,cid);
        } catch (IOException e) {
            e.printStackTrace();
            return cid+"#"+e.getMessage();
        }
        return cid;
    }
}
