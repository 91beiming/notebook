package com.beiming.notebook.service.model;

import com.beiming.notebook.common.entity.BaseObject;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * PhotoAlbum
 */
@Getter
@Setter
public class PhotoAlbumDTO extends BaseObject {
    private Long id;

    /**
     * 相册名称
     */
    private String name;

    private String remark;

    /**
     * 相册是否公开 1公开,0不公开,默认0
     */
    private Integer isPublice;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}