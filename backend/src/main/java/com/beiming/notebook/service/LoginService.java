package com.beiming.notebook.service;

import com.beiming.notebook.common.constant.LuaScripts;
import com.beiming.notebook.common.constant.RedisKey;
import com.beiming.notebook.common.constant.UserRedisConstant;
import com.beiming.notebook.common.utils.JsonUtils;
import com.beiming.notebook.dao.impl.UserDAO;
import com.beiming.notebook.dao.model.User;
import com.beiming.notebook.service.model.UserDTO;
import com.beiming.notebook.dao.model.UserLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.UUID;

/**
 * LoginService
 */
@Slf4j
public abstract class LoginService {

    private final StringRedisTemplate stringRedisTemplate;
    private final UserDAO userDAO;

    //    private final static int
    protected LoginService(StringRedisTemplate stringRedisTemplate, UserDAO userDAO) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.userDAO = userDAO;
    }


    public String login(String key, String secret) {
        UserLogin userLogin = getUserLogin(key, secret);
        User user = userDAO.getByUserId(userLogin.getUserId());
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");

        UserDTO userDTO = user.clone(UserDTO.class);
        userDTO.setUuid(uuid);
        String result = stringRedisTemplate.execute(LuaScripts.USER_LOGIN,
                List.of(RedisKey.USER_UUID_KEY + uuid, RedisKey.USER_UUID_LIST_KEY + user.getId()),
                JsonUtils.toJson(userDTO),
                UserRedisConstant.EXPIRE_TIME.toString(),
                UserRedisConstant.ONLINE_LIMIT.toString()
        );
        log.info("LoginService.login: 执行redis登录脚本 {}", result);
        return uuid;
    }

    protected abstract UserLogin getUserLogin(String key, String secret);

    public abstract String getType();
}
