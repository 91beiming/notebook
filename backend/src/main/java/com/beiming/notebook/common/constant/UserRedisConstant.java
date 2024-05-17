package com.beiming.notebook.common.constant;

/**
 * UserRedisConstant
 */
public interface UserRedisConstant {
    /**
     * 过期时间 4个小时,单位秒
     */
    Long EXPIRE_TIME = 60 * 60 * 4L;

    /**
     * 同一账号登录只保留三个登陆凭证
     */
    Integer ONLINE_LIMIT = 3;
}
