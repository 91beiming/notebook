package com.beiming.notebook.controller.model;

import com.beiming.notebook.common.entity.BaseObject;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * PhotoAlbum
 */
@Getter
@Setter
public class PhotoAlbumParams extends BaseObject {
    @NotNull(message = "id不能为空", groups = {updateName.class, togglePublic.class, deleteById.class, addPhoto.class, deletePhotoById.class})
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

    /**
     * 图片地址
     */
    @NotBlank(message = "图片地址不能为空", groups = {addPhoto.class})
    private String path;

    /**
     * 缩略图地址
     */
    @NotBlank(message = "缩略图地址不能为空", groups = {addPhoto.class})
    private String thumbPath;

    public interface updateName {
    }

    public interface togglePublic {
    }

    public interface deleteById {
    }

    public interface addPhoto {
    }

    public interface deletePhotoById {
    }
}