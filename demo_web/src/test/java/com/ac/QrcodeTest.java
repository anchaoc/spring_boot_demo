package com.ac;

import com.ac.qrcode.QRCodeUtil;
import com.google.zxing.Result;

/**
 * @author anchao
 * @date 2020/1/7 14:01
 */
public class QrcodeTest {

    public static void main(String[] args) {

        //QRCodeUtil.zxingCodeCreate("https://www.baidu.com/s?ie=utf-8&tn=02003390_23_hao_pg&wd=臭外包", "D:/qrcode/",500,"D:/1.jpg");
        Result result = QRCodeUtil.zxingCodeAnalyze("D:/qrcode/1.jpg");
        System.err.println("二维码解析内容："+result.toString());


    }

}
