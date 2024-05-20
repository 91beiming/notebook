package com.beiming.notebook.service;

import com.beiming.notebook.dao.model.PhotoAlbum;
import com.beiming.notebook.service.model.PhotoAlbumDTO;

import java.util.List;

/**
 * PhotoAlbumService
 */
public interface PhotoAlbumService {
    void add(PhotoAlbum photoAlbum);

    void updateNameById(PhotoAlbum photoAlbum);

    void togglePublic(PhotoAlbum photoAlbum);

    void deleteById(Long id);

    List<PhotoAlbumDTO> list();
}
