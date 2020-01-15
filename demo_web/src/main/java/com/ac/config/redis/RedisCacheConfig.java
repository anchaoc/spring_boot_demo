//package com.ac.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.cache.RedisCacheWriter;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializationContext;
//import org.springframework.data.redis.serializer.RedisSerializer;
//
//import java.time.Duration;
//
///**
// *
// */
//@Slf4j
//@EnableCaching
//@Configuration
//public class RedisCacheConfig {
//
//    /**
//     * 替换spring cache
//     */
//    @Bean
//    public CacheManager cacheManager(RedisTemplate redisTemplate) {
//        //初始化一个RedisCacheWriter
//        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisTemplate.getConnectionFactory());
//        //设置CacheManager的值序列化方式为json序列化
//        RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair
//                .fromSerializer(this.getJackson());
//        RedisCacheConfiguration defaultCacheConfig=RedisCacheConfiguration.defaultCacheConfig()
//                .serializeValuesWith(pair);
//        //设置默认超过期时间是2小时
//        defaultCacheConfig.entryTtl(Duration.ofHours(2));
//        defaultCacheConfig.disableCachingNullValues();
//        //初始化RedisCacheManager
//        return new RedisCacheManager(redisCacheWriter, defaultCacheConfig);
//    }
//
//    /**
//     *redis模板设置
//     */
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(){
//        RedisTemplate template = new RedisTemplate();
//        template.setValueSerializer(this.getJackson());
//        template.afterPropertiesSet();
//        return template;
//    }
//
//    /**
//     * 设置jackson序列化
//     */
//    private RedisSerializer getJackson(){
//        return new GenericJackson2JsonRedisSerializer();
//    }
//}
