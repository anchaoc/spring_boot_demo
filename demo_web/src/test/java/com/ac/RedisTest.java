package com.ac;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.Jedis;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

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
        test3();
    }


    private static void test2(){
        //System.out.println(jedis.set("string-key","1"));
        //System.out.println(jedis.lpush("list-key", new String[]{"1","2"}));
        //System.out.println(jedis.hset("hash-key","set-fieid","1"));
        // System.out.println(jedis.zadd("zset-key",1,"1"));
        //System.out.println(jedis.sadd("set-key", new String[]{"1","2"}));
//        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("127.0.0.1",6379);
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration);
//        RedisAtomicLong test = new RedisAtomicLong("test",jedisConnectionFactory);
//        long andIncrement = test.getAndIncrement();
//        System.out.println(andIncrement);
    }






    /**
     * jedis
     */
    private static void test1(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        try {
            HashMap<String, String> map = Maps.newHashMap();
            map.put("key5",Math.incrementExact(1L)+"" );
            String hmset = jedis.hmset("hash-key", map);
            System.out.println(hmset);


        }finally {
            System.out.println("jedis close");
            jedis.close();
        }
    }

    /**
     * redis template
     */
    private static void test3(){
        LocalDate now = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration("127.0.0.1",6379);
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration);
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setValueSerializer(RedisSerializer.string());
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        redisTemplate.afterPropertiesSet();

//        String oldDate = now.plusDays(-1).format(dateTimeFormatter);
//        String nowDate = now.format(dateTimeFormatter);
//
//        Boolean delete = redisTemplate.delete("test-" + oldDate);
//        System.out.println(delete);
//
//
//        RedisAtomicLong redisAtomicLong = new RedisAtomicLong("test-"+nowDate, jedisConnectionFactory);
//        long incrementAndGet = redisAtomicLong.incrementAndGet();
//        System.out.println(incrementAndGet);

        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                System.out.println(connection.setNX("lock-key".getBytes(), "1".getBytes()));
                return null;
            }
        });
    }
}
