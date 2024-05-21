package com.beiming.notebook.controller.model;

import com.beiming.notebook.common.entity.BaseObject;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * TagParams
 */
@Setter
@Getter
public class TagParams extends BaseObject {
    @NotNull(message = "id不能为空", groups = {updateTag.class, deleteById.class})
    private Long id;

    private Long pid;

    /**
     * 文章名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

m
    public interface updateTag {
    }

    public interface deleteById {
    }
}
