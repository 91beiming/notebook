package com.beiming.notebook.controller;

import com.beiming.notebook.controller.model.LoginParams;
import com.beiming.notebook.service.LoginService;
import com.beiming.notebook.service.impl.LoginFactory;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * LoginController
 */
@RestController
@RequestMapping("login")
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    @Resource
    private LoginFactory loginFactory;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RestTemplateBuilder restTemplateBuilder;

    @PostMapping("email")
    public String loginByEmail(@RequestBody LoginParams params) {
        LoginService loginService = loginFactory.getLoginService("by_email");
        return loginService.login(params.getKey(), params.getSecret());
    }
}
