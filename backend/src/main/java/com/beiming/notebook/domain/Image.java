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
 * Image
 */
@Getter
@Setter
@TableName(value = "image")
public class Image extends BaseObject {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 文件摘要值
     */
    @TableField(value = "md5")
    private String md5;

    /**
     * 原始文件名
     */
    @TableField(value = "origin_filename")
    private String originFilename;

    /**
     * 路径
     */
    @TableField(value = "`path`")
    private String path;

    @TableField(value = "`size`")
    private Long size;

    /**
     * 缩略图路径
     */
    @TableField(value = "thumb_path")
    private String thumbPath;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;
}