package com.beiming.notebook.module.tag.model;

import com.beiming.notebook.common.entity.BaseObject;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * TagParams
 */
@Setter
@Getter
public class TagDTO extends BaseObject {
    private Long id;

    private Long pid;

    /**
     * 文章名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
