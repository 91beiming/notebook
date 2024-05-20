package com.beiming.notebook.service.model;

import com.beiming.notebook.common.entity.BaseObject;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

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

    private List<TagDTO> children;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
