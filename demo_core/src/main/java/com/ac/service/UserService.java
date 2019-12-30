package com.ac.service;

import com.ac.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


/**
 * @author anchao
 */
public interface UserService extends IService<User> {

    List<User> getAll();
}
