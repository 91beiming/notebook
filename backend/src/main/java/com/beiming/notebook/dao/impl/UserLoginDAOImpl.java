package com.beiming.notebook.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.beiming.notebook.dao.UserLoginDAO;
import com.beiming.notebook.dao.mapper.UserLoginMapper;
import com.beiming.notebook.domain.UserLogin;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

/**
 * UserLoginDAOImpl
 */
@Repository
public class UserLoginDAOImpl implements UserLoginDAO {
    @Resource
    private UserLoginMapper userLoginMapper;

    @Override
    public UserLogin getByKeyAndSecretAndType(String key, String secret, String type) {
        return userLoginMapper.selectOne(
                new LambdaQueryWrapper<UserLogin>()
                        .eq(UserLogin::getKey, key)
                        .eq(UserLogin::getSecret, secret)
                        .eq(UserLogin::getType, type)
        );
    }
}
