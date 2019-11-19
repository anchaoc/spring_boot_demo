package com.ac.service;

import com.ac.model.User;

import java.util.List;
import java.util.Map;

/**
 * @author anchao
 */
public interface UserService {

    List<User> queryUser();

    void save(User u);

    User getUserInfo(Long id);
}
