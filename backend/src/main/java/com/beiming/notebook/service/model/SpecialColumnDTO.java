package com.beiming.notebook.service.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
public class SpecialColumnDTO extends BaseObject {
    private Long id;

    /**
     * 专栏名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}