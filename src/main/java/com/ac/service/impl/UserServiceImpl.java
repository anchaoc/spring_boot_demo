package com.ac.service.impl;

import com.ac.dao.UserMapper;
import com.ac.model.User;
import com.ac.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author anchao
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> queryUser() {
        return userMapper.queryUser();
    }

    /**
     * 线程池异步执行
     * @param u 用户
     */
    @Async("threadPoolTaskExecutor")
    @Override
    public void save(User u) {
        log.warn("当前线程--> "+Thread.currentThread().getName());
        log.warn("插入name--> "+u.getName());
        userMapper.batchSave(u);
    }

    @Override
    public User getUserInfo(Long id) {
        return userMapper.getUserInfo(id);
    }
}
