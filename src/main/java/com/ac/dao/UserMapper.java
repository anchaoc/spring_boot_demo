package com.ac.dao;

import com.ac.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author anchao
 */
@Repository
public interface UserMapper {

    List<User> queryUser();

    void batchSave(User u);

    User getUserInfo(Long id);
}
