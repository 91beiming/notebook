package com.beiming.notebook.dao;

import com.beiming.notebook.dao.mapper.UserMapper;
import com.beiming.notebook.dao.model.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * UserDAOImpl
 */
@Service
public class UserDAO {

    @Resource
    private UserMapper userMapper;


    public User getByUserId(Long userId) {
        return userMapper.selectById(userId);
    }
}
