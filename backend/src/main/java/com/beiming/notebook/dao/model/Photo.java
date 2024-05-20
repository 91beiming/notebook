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
 * Photo
 */
@Getter
@Setter
@TableName(value = "photo")
public class Photo extends BaseObject {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 图片地址
     */
    @TableField(value = "`path`")
    private String path;

    /**
     * 缩略图地址
     */
    @TableField(value = "thumb_path")
    private String thumbPath;

    @TableField(value = "create_time")
    private LocalDateTime createTime;
}