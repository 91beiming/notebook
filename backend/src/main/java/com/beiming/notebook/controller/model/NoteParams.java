package com.beiming.notebook.controller.model;

import com.beiming.notebook.common.entity.BaseQuery;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Note
 */

/**
 * 笔记表
 */
@Getter
@Setter
public class NoteParams extends BaseQuery {
    @NotNull(message = "id不能为空", groups = {updateContentById.class, togglePublic.class, linkTag.class})
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
    @NotBlank(message = "内容不能为空", groups = {updateContentById.class})
    private String content;

    private List<Long> tagIdList;


    public interface updateContentById {
    }

    public interface togglePublic {
    }

    public interface linkTag {
    }

}