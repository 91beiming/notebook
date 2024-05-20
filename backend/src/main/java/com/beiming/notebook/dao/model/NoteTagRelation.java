package com.beiming.notebook.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.beiming.notebook.common.entity.BaseObject;
import lombok.Getter;
import lombok.Setter;

/**
 * NoteTagRelation
 */

/**
 * 笔记标签关联表
 */
@Getter
@Setter
@TableName(value = "note_tag_relation")
public class NoteTagRelation extends BaseObject {
    /**
     * 笔记ID
     */
    @TableId(value = "note_id", type = IdType.AUTO)
    private Long noteId;

    /**
     * 标签ID
     */
    @TableField(value = "tag_id")
    private Long tagId;
}