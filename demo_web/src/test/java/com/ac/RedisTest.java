package com.ac;

import com.ac.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author anchao
 * @date 2019/12/30 11:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
@Slf4j
public class RedisTest {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Resource
    private UserService userService;

    @Test
    public void testRedis(){
        log.info("------------>userInfo={}",userService.getAll());
    }
}
