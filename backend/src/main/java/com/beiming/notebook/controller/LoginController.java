package com.beiming.notebook.controller;

import com.beiming.notebook.common.utils.JsonUtils;
import com.beiming.notebook.controller.model.LoginParams;
import com.beiming.notebook.service.LoginService;
import com.beiming.notebook.service.impl.LoginFactory;
import com.beiming.notebook.service.model.UserDTO;
import com.beiming.notebook.service.model.WxUserInfo;
import com.beiming.notebook.service.model.YiDengResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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


    /**
     * 微信登陆,获取二维码
     */
    @GetMapping("weixin/qr")
    public UserDTO wxQr() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String secret = stringRedisTemplate.opsForValue().get("yideng:secret");
        String yidengResultJsonStr = restTemplate.getForObject("https://yd.jylt.cc/api/wxLogin/tempUserId?secret=" + secret, String.class);
        log.info("LoginController.wxQr: 微信二维码信息 {}", yidengResultJsonStr);
        YiDengResponse<UserDTO> reponse = JsonUtils.toObject(yidengResultJsonStr, new TypeReference<YiDengResponse<UserDTO>>() {
        });
        log.info("LoginController.wxQr: 微信二维码解析 {}", reponse);
        return reponse.getData();
    }

    @PostMapping("/wx/callback")
    public YiDengResponse<?> wxCallback(@RequestBody String params) {
        log.info("LoginController.wxCallback: 微信授权回调接口 {}", params);
        WxUserInfo wxUserInfo = JsonUtils.toObject(params, WxUserInfo.class);
        WxUserInfo.UserInfo userInfo = wxUserInfo.getWxMaUserInfo();
        log.info("LoginController.wxCallback: 获取wx用户信息 {}", userInfo);
        YiDengResponse<?> r = new YiDengResponse<>();
        r.setCode(0);
        r.setMsg("登录成功");
        return r;
    }
}
