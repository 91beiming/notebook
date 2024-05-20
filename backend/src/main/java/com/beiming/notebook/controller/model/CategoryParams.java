package com.beiming.notebook.controller.model;

import com.beiming.notebook.common.entity.BaseObject;
import jakarta.validation.constraints.NotNull;
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
public class CategoryParams extends BaseObject {
    @NotNull(message = "id不能为空", groups = {updateById.class, deleteById.class})
    private Long id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    public interface updateById {
    }

    public interface deleteById{}
}