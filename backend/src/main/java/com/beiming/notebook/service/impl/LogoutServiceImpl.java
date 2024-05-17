package com.beiming.notebook.service.impl;

import com.beiming.notebook.common.constant.LuaScripts;
import com.beiming.notebook.common.constant.RedisKey;
import com.beiming.notebook.service.LogoutService;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * LogoutServiceImpl
 */
@Service
public class LogoutServiceImpl implements LogoutService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void logout(Long userId, String uuid) {
        stringRedisTemplate.execute(LuaScripts.USER_LOGOUT,
                List.of(
                        RedisKey.USER_UUID_KEY + uuid,
                        RedisKey.USER_UUID_LIST_KEY + userId
                ));
    }
}
