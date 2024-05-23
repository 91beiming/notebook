package com.beiming.notebook.service.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.beiming.notebook.common.entity.BaseObject;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Note
 */

/**
 * 笔记表
 */
@Getter
@Setter
public class NoteDTO extends BaseObject {
    private Long id;

    private Long userId;

    /**
     * 分类ID
     */
    private Long categoryId;

    /**
     * 专栏ID
     */
    private Long specialColumnId;

    /**
     * 笔记标题
     */
    private String title;

    /**
     * 笔记内容(markdown)
     */
    private String content;

    /**
     * 是否公开(1,公开,0 不公开)
     */
    private Integer isPublic;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private List<TagDTO> tagList;

    private CategoryDTO category;
}