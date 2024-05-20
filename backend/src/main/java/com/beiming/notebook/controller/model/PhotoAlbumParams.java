package com.beiming.notebook.controller.model;

import com.beiming.notebook.common.entity.BaseObject;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * PhotoAlbum
 */
@Getter
@Setter
public class PhotoAlbumParams extends BaseObject {
    @NotNull(message = "id不能为空", groups = {updateName.class, togglePublic.class, deleteById.class})
    private Long id;

    /**
     * 相册名称
     */
    @NotNull(message = "名称不能为空", groups = {updateName.class})
    private String name;

    private String remark;

    /**
     * 相册是否公开 1公开,0不公开,默认0
     */
    private Integer isPublice;

    public interface updateName {
    }

    public interface togglePublic {
    }

    public interface deleteById {
    }
}