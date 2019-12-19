package com.ac.service.impl;

import com.ac.dao.UserMapper;
import com.ac.model.User;
import com.ac.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


/**
 * @author anchao
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
}
