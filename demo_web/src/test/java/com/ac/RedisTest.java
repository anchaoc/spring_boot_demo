package com.ac;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import redis.clients.jedis.Jedis;

/**
 * @author anchao
 * @date 2019/12/30 11:56
 */
@Slf4j
public class RedisTest {

//    @Resource
    //private RedisTemplate<String,Object> redisTemplate;
//
//    @Resource
//    private UserService userService;


    public static void main(String[] args) {
        testRedis();
    }


    private static void testRedis(){
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("127.0.0.1",6379);
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration);
        RedisAtomicLong test = new RedisAtomicLong("test",jedisConnectionFactory);
        long andIncrement = test.getAndIncrement();
        System.out.println(andIncrement);
    }






    /**
     * jedis
     */
    private static void test1(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        try {
        }finally {
            jedis.close();
        }
    }
}
