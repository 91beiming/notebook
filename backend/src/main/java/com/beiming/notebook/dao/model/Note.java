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
 * Note
 */

/**
 * 笔记表
 */
@Getter
@Setter
@TableName(value = "note")
public class Note extends BaseObject {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "user_id")
    private Long userId;

    /**
     * 分类ID
     */
    @TableField(value = "category_id")
    private Long categoryId;

    /**
     * 专栏ID
     */
    @TableField(value = "special_column_id")
    private Long specialColumnId;

    /**
     * 笔记标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 笔记内容(markdown)
     */
    @TableField(value = "content")
    private String content;

    /**
     * 是否公开(1,公开,0 不公开)
     */
    @TableField(value = "is_public")
    private Integer isPublic;

    /**
     * 逻辑删除
     */
    @TableField(value = "is_deleted")
    private Integer isDeleted;

    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @TableField(value = "update_time")
    private LocalDateTime updateTime;
}