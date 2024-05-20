package com.beiming.notebook.service.impl;

import com.beiming.notebook.common.utils.BeanCopyUtils;
import com.beiming.notebook.dao.PhotoAlbumDAO;
import com.beiming.notebook.dao.model.PhotoAlbum;
import com.beiming.notebook.service.PhotoAlbumService;
import com.beiming.notebook.service.model.PhotoAlbumDTO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PhotoAlbumServiceImpl
 */
@Service
public class PhotoAlbumServiceImpl implements PhotoAlbumService {
    @Resource
    private PhotoAlbumDAO photoAlbumDAO;

    @Override
    public void add(PhotoAlbum photoAlbum) {
        photoAlbumDAO.add(photoAlbum);
    }

    @Override
    public void updateNameById(PhotoAlbum photoAlbum) {
        photoAlbumDAO.updateNameById(photoAlbum.getId(), photoAlbum.getName());
    }

    @Override
    public void togglePublic(PhotoAlbum photoAlbum) {
        photoAlbumDAO.togglePublic(photoAlbum.getId());
    }

    @Override
    public void deleteById(Long id) {
        photoAlbumDAO.deleteById(id);
    }

    @Override
    public List<PhotoAlbumDTO> list() {
        List<PhotoAlbum> list = photoAlbumDAO.list();
        return BeanCopyUtils.copyList(list, PhotoAlbumDTO.class);
    }

    @Override
    public void addPhoto(Long id, String path, String thumbPath) {
        photoAlbumDAO.addPhoto(id, path, thumbPath);
    }

    @Override
    public void deletePhotoById(Long id) {
        photoAlbumDAO.deletePhotoById(id);
    }
}
