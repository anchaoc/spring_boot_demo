package com.ac;


import com.ac.client.GoogleTranslateApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author anchao
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class SpringBootDemoTest {

    @Resource
    GoogleTranslateApi googleTranslateApi;

    @Test
    public void test(){
        googleTranslateApi.getranslate();
    }
}
