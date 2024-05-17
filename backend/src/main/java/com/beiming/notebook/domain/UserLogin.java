package com.beiming.notebook.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.beiming.notebook.common.entity.BaseObject;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * UserLogin
 */
/**
 * 用户登陆表
 */
@Getter
@Setter
@TableName(value = "user_login")
public class UserLogin extends BaseObject {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 登陆key
     */
    @TableField(value = "`key`")
    private String key;

    /**
     * 登陆密钥/密码
     */
    @TableField(value = "secret")
    private String secret;

    /**
     * 登陆方式
     */
    @TableField(value = "`type`")
    private String type;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @TableField(value = "update_time")
    private LocalDateTime updateTime;
}