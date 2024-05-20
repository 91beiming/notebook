package com.beiming.notebook.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value = "category")
public class Category extends BaseObject {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 分类名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;
}