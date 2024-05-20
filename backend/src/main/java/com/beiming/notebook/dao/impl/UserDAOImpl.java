package com.beiming.notebook.dao.impl;

import com.beiming.notebook.dao.UserDAO;
import com.beiming.notebook.dao.mapper.UserMapper;
import com.beiming.notebook.dao.model.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * UserDAOImpl
 */
@Service
public class UserDAOImpl implements UserDAO {

    @Resource
    private UserMapper userMapper;


    @Override
    public User getByUserId(Long userId) {
        return userMapper.selectById(userId);
    }
}
