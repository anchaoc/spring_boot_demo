package com.ac.controller.qrcode;

import com.ac.qrcode.QRCodeUtil;
import com.google.zxing.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 二维码调用前端控制器
 */
@ApiIgnore
@RequestMapping("/Qrcode")
@RestController
public class QrcodeController {

    /**
     * 生成二维码
     */
    @GetMapping
    public void productcode() {
        QRCodeUtil.zxingCodeCreate("http://www.baidu.com", "D:/qrcode/",500,"D:/1.jpg");
    }


    /**
     * 解析二维码
     */
    @GetMapping("/test")
    public void analysiscode() {
        Result result = QRCodeUtil.zxingCodeAnalyze("D:/qrcode/643.jpg");
        System.err.println("二维码解析内容："+result.toString());
    }



}
