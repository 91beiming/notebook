package com.beiming.notebook.dao.impl;

import com.beiming.notebook.dao.mapper.UserMapper;
import com.beiming.notebook.dao.model.User;
import org.springframework.stereotype.Service;

/**
 * UserDAOImpl
 */
@Service
public class UserDAO {

    private UserMapper userMapper;


    public User getByUserId(Long userId) {
        return userMapper.selectById(userId);
    }
}
