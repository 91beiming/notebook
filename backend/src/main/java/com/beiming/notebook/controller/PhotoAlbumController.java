package com.beiming.notebook.controller;

import com.beiming.notebook.controller.model.PhotoAlbumParams;
import com.beiming.notebook.dao.model.PhotoAlbum;
import com.beiming.notebook.service.PhotoAlbumService;
import com.beiming.notebook.service.model.PhotoAlbumDTO;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * PhotoAlbumController
 */
@RestController
@RequestMapping("photo_album")
public class PhotoAlbumController {

    @Resource
    private PhotoAlbumService photoAlbumService;

    /**
     * 创建相册
     */
    @PostMapping("add")
    public Boolean add(@RequestBody PhotoAlbumParams params) {
        photoAlbumService.add(params.clone(PhotoAlbum.class));
        return true;
    }

    /**
     * 修改相册名称
     */
    @PostMapping("updateNameById")
    public Boolean updateNameById(@RequestBody @Validated(PhotoAlbumParams.updateName.class) PhotoAlbumParams params) {
        photoAlbumService.updateNameById(params.clone(PhotoAlbum.class));
        return true;
    }

    /**
     * 切换相册公开状态
     */
    @PostMapping("togglePublic")
    public Boolean togglePublic(@RequestBody @Validated(PhotoAlbumParams.togglePublic.class) PhotoAlbumParams params) {
        photoAlbumService.togglePublic(params.clone(PhotoAlbum.class));
        return true;
    }

    /**
     * 删除相册
     */
    @PostMapping("deleteById")
    public Boolean deleteById(@RequestBody @Validated(PhotoAlbumParams.deleteById.class) PhotoAlbumParams params) {
        photoAlbumService.deleteById(params.getId());
        return true;
    }

    /**
     * 相册列表
     */
    @GetMapping("list")
    public List<PhotoAlbumDTO> list() {
        return photoAlbumService.list();
    }

    /**
     * 给相册添加相片
     */
    @PostMapping("photo/add")
    public Boolean addPhoto(@RequestBody @Validated(PhotoAlbumParams.addPhoto.class) PhotoAlbumParams params) {
        photoAlbumService.addPhoto(params.getId(), params.getPath(), params.getThumbPath());
        return true;
    }

    /**
     * 从相册中删除图片
     */
    @PostMapping("photo/deleteById")
    public Boolean deletePhotoById(@RequestBody @Validated(PhotoAlbumParams.deletePhotoById.class) PhotoAlbumParams params) {
        photoAlbumService.deletePhotoById(params.getId());
        return true;
    }
}

