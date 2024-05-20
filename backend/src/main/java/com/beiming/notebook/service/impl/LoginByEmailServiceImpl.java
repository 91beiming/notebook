package com.beiming.notebook.service.impl;

import com.beiming.notebook.common.exception.CustomerException;
import com.beiming.notebook.dao.UserDAO;
import com.beiming.notebook.dao.UserLoginDAO;
import com.beiming.notebook.dao.model.UserLogin;
import com.beiming.notebook.service.LoginService;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * LoginByEmailServiceImpl
 * 邮箱登陆
 */
@Service
public class LoginByEmailServiceImpl extends LoginService {

    @Resource
    private UserLoginDAO userLoginDAO;

    protected LoginByEmailServiceImpl(StringRedisTemplate stringRedisTemplate, UserDAO userDAO) {
        super(stringRedisTemplate, userDAO);
    }


    @Override
    protected UserLogin getUserLogin(String key, String secret) {
        UserLogin userLogin = userLoginDAO.getByKeyAndSecretAndType(
                key,
                DigestUtils.md5DigestAsHex((key + secret).getBytes(StandardCharsets.UTF_8)),
                getType()
        );
        if (userLogin != null) {
            return userLogin;
        } else {
            throw new CustomerException("邮箱或密码错误");
        }
    }

    @Override
    public String getType() {
        return "by_email";
    }
}
