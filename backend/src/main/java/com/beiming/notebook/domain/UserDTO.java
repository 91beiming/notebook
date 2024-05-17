package com.beiming.notebook.domain;

import com.beiming.notebook.common.entity.BaseObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * User
 */

/**
 * 用户表
 */
@Getter
@Setter
@ToString
public class UserDTO extends BaseObject {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 是否是管理员
     */
    private Integer isAdmin;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String uuid;

    private String qrUrl;

    private String tempUserId;
}