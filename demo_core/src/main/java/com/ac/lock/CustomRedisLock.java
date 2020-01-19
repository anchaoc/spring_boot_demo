package com.ac.lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * <p>Description: [自定义redis lock]</p>
 * Created on 2018年12月14日
 *
 * @author <a href="mailto:liuxiangping@camelotchina.com">刘香平</a>
 * @version 1.0
 * Copyright (c) 2018 北京柯莱特科技有限公司 交付部
 */
@Slf4j
public class CustomRedisLock {

    private RedisTemplate<String, String> redisTemplate;

    /**
     * 轮询lock时间
     */
    private static final int DEFAULT_ACQUIRY_RESOLUTION_MILLIS = 100;

    /**
     * 锁KEY
     */
    private String lockKey;

    /**
     * 锁超时时间，防止线程在入锁以后，无限的执行等待
     */
    private int expireMsecs = 60 * 1000;

    /**
     * 锁等待时间，防止线程饥饿
     */
    private int timeoutMsecs = 10 * 1000;

    /**
     * 是否锁定
     */
    private volatile boolean locked = false;

    /**
     * <p>Discription:[实例自定义redis lock]</p>
     * Created on 2018年12月14日
     *
     * @param redisTemplate spring redis 操作实例
     * @param lockKey       lock key
     * @author:[刘香平]
     */
    public CustomRedisLock(RedisTemplate<String, String> redisTemplate, String lockKey) {

        this.redisTemplate = redisTemplate;
        this.lockKey = lockKey;
    }

    /**
     * <p>Discription:[实例自定义redis lock]</p>
     * Created on 2018年12月14日
     *
     * @param redisTemplate spring redis 操作实例
     * @param lockKey       lock key
     * @param timeoutMsecs  锁等待时间，防止线程饥饿
     * @author:[刘香平]
     */
    public CustomRedisLock(RedisTemplate<String, String> redisTemplate, String lockKey, int timeoutMsecs) {

        this(redisTemplate, lockKey);
        this.timeoutMsecs = timeoutMsecs;
    }

    /**
     * <p>Discription:[实例自定义redis lock]</p>
     * Created on 2018年12月14日
     *
     * @param redisTemplate spring redis 操作实例
     * @param lockKey       lock key
     * @param timeoutMsecs  锁等待时间，防止线程饥饿
     * @param expireMsecs   锁超时时间，防止线程在入锁以后，无限的执行等待
     * @author:[刘香平]
     */
    public CustomRedisLock(RedisTemplate<String, String> redisTemplate, String lockKey, int timeoutMsecs, int expireMsecs) {

        this(redisTemplate, lockKey, timeoutMsecs);
        this.expireMsecs = expireMsecs;
    }

    /**
     * <p>Discription:[获取lock]</p>
     * Created on 2018年12月14日
     *
     * @param key
     * @return
     * @author:[刘香平]
     */
    private String get(final String key) {

        Object obj = null;
        try {
            obj = redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    StringRedisSerializer serializer = new StringRedisSerializer();
                    byte[] data = connection.get(serializer.serialize(key));
                    connection.close();
                    if (data == null) {
                        return null;
                    }
                    return serializer.deserialize(data);
                }
            });
        } catch (Exception e) {
            log.error("获取 redis lock 异常, key : {}", key, e);
        }
        return obj != null ? obj.toString() : null;
    }

    /**
     * <p>Discription:[设置Lock]</p>
     * Created on 2018年12月14日
     *
     * @param key
     * @param value
     * @return
     * @author:[刘香平]
     */
    private boolean setNX(final String key, final String value) {

        Object obj = null;
        try {
            obj = redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    StringRedisSerializer serializer = new StringRedisSerializer();
                    Boolean success = connection.setNX(serializer.serialize(key), serializer.serialize(value));
                    connection.close();
                    return success;
                }
            });
        } catch (Exception e) {
            log.error("设置 redis lock 异常, key : {}", key, e);
        }
        return obj != null;
    }

    /**
     * <p>Discription:[获取当前lock的时间戳]</p>
     * Created on 2018年12月14日
     *
     * @param key
     * @param value
     * @return
     * @author:[刘香平]
     */
    private String getSet(final String key, final String value) {
        Object obj = null;
        try {
            obj = redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    StringRedisSerializer serializer = new StringRedisSerializer();
                    byte[] ret = connection.getSet(serializer.serialize(key), serializer.serialize(value));
                    connection.close();
                    return serializer.deserialize(ret);
                }
            });
        } catch (Exception e) {
            log.error("设置 redis lock 异常, key : {}", key, e);
        }
        return obj != null ? (String) obj : null;
    }

    /**
     * <p>Discription:[获得 lock]</p>
     * Created on 2018年12月14日
     *
     * @return
     * @throws InterruptedException
     * @author:[刘香平]
     */
    public synchronized boolean lock() throws InterruptedException {

        int timeout = timeoutMsecs;
        while (timeout >= 0) {
            long expires = System.currentTimeMillis() + expireMsecs + 1;
            String expiresStr = String.valueOf(expires);
            if (this.setNX(lockKey, expiresStr)) {
                locked = true;
                return true;
            }
            String currentValueStr = this.get(lockKey);
            if (currentValueStr != null && Long.parseLong(currentValueStr) < System.currentTimeMillis()) {
                String oldValueStr = this.getSet(lockKey, expiresStr);
                if (oldValueStr != null && oldValueStr.equals(currentValueStr)) {
                    locked = true;
                    return true;
                }
            }
            timeout -= DEFAULT_ACQUIRY_RESOLUTION_MILLIS;
            wait(DEFAULT_ACQUIRY_RESOLUTION_MILLIS);
        }
        return false;
    }


    /**
     * <p>Discription:[释放锁]</p>
     * Created on 2018年12月14日
     *
     * @author:[刘香平]
     */
    public synchronized void unlock() {
        if (locked) {
            redisTemplate.delete(lockKey);
            locked = false;
        }
    }
}
