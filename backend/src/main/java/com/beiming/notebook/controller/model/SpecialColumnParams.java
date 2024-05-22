package com.beiming.notebook.controller.model;

import com.beiming.notebook.common.entity.BaseObject;
import com.beiming.notebook.common.entity.BaseQuery;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * SpecialColumn
 */

/**
 * 专栏
 */
@Getter
@Setter
public class SpecialColumnParams extends BaseQuery {
    @NotNull(message = "id不能为空", groups = {updateName.class})
    private Long id;

    /**
     * 专栏名称
     */
    @NotBlank(message = "名称不能为空", groups = {updateName.class})
    private String name;

    /**
     * 备注
     */
    private String remark;

    public interface updateName {
    }

}