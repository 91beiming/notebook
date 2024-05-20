package com.beiming.notebook.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.beiming.notebook.common.entity.BaseObject;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * User
 */

/**
 * 用户表
 */
@Getter
@Setter
@TableName(value = "`user`")
public class User extends BaseObject {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 头像
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 简介
     */
    @TableField(value = "introduction")
    private String introduction;

    /**
     * 是否是管理员
     */
    @TableField(value = "is_admin")
    private Integer isAdmin;

    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @TableField(value = "update_time")
    private LocalDateTime updateTime;
}