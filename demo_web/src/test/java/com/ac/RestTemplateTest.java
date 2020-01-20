package com.ac;

import com.ac.common.utils.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author anchao
 * @date 2020/1/20 13:48
 */
@Slf4j
public class RestTemplateTest {

    //天气接口
    //http://ip.tianqiapi.com/?appid=41415293&appsecret=foCsFs7b&ip=127.0.0.1


    private static final String URL="https://www.tianqiapi.com/api/?appid=41415293&appsecret=foCsFs7b&version=v1&cityid=101010100";




    public static void main(String[] args) throws Exception {
        test1();
    }




    private static void test1() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        Map forObject = restTemplate.getForObject(URL, Map.class);
        log.info("返回："+ GsonUtil.toJson(forObject));
    }
}
