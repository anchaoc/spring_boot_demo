package com.ac.service.impl;

import com.ac.dao.UserMapper;
import com.ac.model.User;
import com.ac.service.UserService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author anchao
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.selectList(Wrappers.query());
    }









//@Cacheable(cacheNames = "user_info",unless = "#result.isEmpty() || result==null")
//    @Cacheable(cacheNames = "user_info",
//            key = "'user_info_' + #employeeId",
//            condition = "#employeeId != null and #employeeId != ''",
//            unless = "#result==null")
}
