package com.beiming.notebook.common.constant;

import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.RedisScript;

/**
 * LuaScripts
 */
public interface LuaScripts {
    /**
     * 用户登录,缓存用户信息,过期时间,登录凭证个数
     * 参数 [user:xx,user:list:id] 过期时间 限制数
     */
    RedisScript<String> USER_LOGIN = RedisScript.of(new ClassPathResource("lua/user_login.lua"), String.class);

    /**
     * 获取用户信息并重置过期时间
     * 参数 [user:xx] 过期时间
     */
    RedisScript<String> GET_USER = RedisScript.of(new ClassPathResource("lua/get_user.lua"), String.class);

    /**
     * 用户退出
     * 参数 [user:xx,user:list:id]
     */
    RedisScript<Boolean> USER_LOGOUT = RedisScript.of(new ClassPathResource("lua/user_logout.lua"), Boolean.class);

}
