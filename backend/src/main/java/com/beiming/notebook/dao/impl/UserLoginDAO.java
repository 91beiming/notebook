package com.beiming.notebook.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.beiming.notebook.dao.mapper.UserLoginMapper;
import com.beiming.notebook.dao.model.UserLogin;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

/**
 * UserLoginDAOImpl
 */
@Repository
public class UserLoginDAO {
    @Resource
    private UserLoginMapper userLoginMapper;

    public UserLogin getByKeyAndSecretAndType(String key, String secret, String type) {
        return userLoginMapper.selectOne(
                new LambdaQueryWrapper<UserLogin>()
                        .eq(UserLogin::getKey, key)
                        .eq(UserLogin::getSecret, secret)
                        .eq(UserLogin::getType, type)
        );
    }
}
