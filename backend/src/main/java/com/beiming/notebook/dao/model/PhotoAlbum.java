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
 * PhotoAlbum
 */
@Getter
@Setter
@TableName(value = "photo_album")
public class PhotoAlbum extends BaseObject {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 相册名称
     */
    @TableField(value = "`name`")
    private String name;

    @TableField(value = "remark")
    private String remark;

    /**
     * 相册是否公开 1公开,0不公开,默认0
     */
    @TableField(value = "is_publice")
    private Integer isPublice;

    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @TableField(value = "update_time")
    private LocalDateTime updateTime;
}