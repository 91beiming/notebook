package com.beiming.notebook.service.model;

import com.beiming.notebook.common.entity.BaseObject;
import lombok.Getter;
import lombok.Setter;

/**
 * Category
 */

/**
 * 分类表
 */
@Getter
@Setter
public class CategoryDTO extends BaseObject {
    private Long id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;
}