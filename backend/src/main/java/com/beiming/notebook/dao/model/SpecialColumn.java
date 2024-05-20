package com.beiming.notebook.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.beiming.notebook.common.entity.BaseObject;
import java.time.LocalDateTime;
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
@TableName(value = "special_column")
public class SpecialColumn extends BaseObject {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 专栏名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @TableField(value = "update_time")
    private LocalDateTime updateTime;
}