package com.beiming.notebook.dao;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.beiming.notebook.common.constant.Is;
import com.beiming.notebook.dao.mapper.PhotoAlbumMapper;
import com.beiming.notebook.dao.mapper.PhotoMapper;
import com.beiming.notebook.dao.model.Photo;
import com.beiming.notebook.dao.model.PhotoAlbum;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PhotoAlbumDAO
 */
@Repository
public class PhotoAlbumDAO {

    @Resource
    private PhotoAlbumMapper photoAlbumMapper;

    @Resource
    private PhotoMapper photoMapper;

    public void add(PhotoAlbum photoAlbum) {
        photoAlbum.setIsPublice(Is.NO);
        photoAlbumMapper.insert(photoAlbum);
    }

    public void updateNameById(Long id, String name) {
        photoAlbumMapper.update(
                new LambdaUpdateWrapper<PhotoAlbum>()
                        .eq(PhotoAlbum::getId, id)
                        .set(PhotoAlbum::getName, name)
        );
    }

    public void togglePublic(Long id) {
        photoAlbumMapper.togglePublic(id);
    }

    public void deleteById(Long id) {
        photoAlbumMapper.deleteById(id);
    }

    public List<PhotoAlbum> list() {
        return photoAlbumMapper.selectList(null);
    }

    public void addPhoto(Long id, String path, String thumbPath) {
        Photo photo = new Photo();
        photo.setPath(path);
        photo.setAlbumId(id);
        photo.setThumbPath(thumbPath);
        photoMapper.insert(photo);
    }

    public void deletePhotoById(Long id) {
        photoMapper.deleteById(id);
    }
}
