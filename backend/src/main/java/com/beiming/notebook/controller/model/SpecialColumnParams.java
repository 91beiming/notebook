package com.beiming.notebook.controller.model;

import com.beiming.notebook.common.entity.BaseObject;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * SpecialColumn
 */

/**
 * 专栏
 */
@Getter
@Setter
public class SpecialColumnParams extends BaseObject {
    private Long id;

    /**
     * 专栏名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

}