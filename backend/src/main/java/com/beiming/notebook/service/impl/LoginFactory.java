package com.beiming.notebook.service.impl;

import com.beiming.notebook.common.exception.CustomerException;
import com.beiming.notebook.service.LoginService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * LoginFactory
 */
@Service
public class LoginFactory {

    @Resource
    private LoginByEmailServiceImpl byEmailService;


    public LoginService getLoginService(String type) {
        if (byEmailService.getType().equals(type)) {
            return byEmailService;
        } else {
            throw new CustomerException("没有该登录信息");
        }
    }
}
