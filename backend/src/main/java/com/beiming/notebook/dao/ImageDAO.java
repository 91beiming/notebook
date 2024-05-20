package com.beiming.notebook.dao;

import com.beiming.notebook.dao.model.Image;

/**
 * PhotoTemoDAO
 */
public interface ImageDAO {
    Image getByMd5AndSize(String md5, long size);

    Image getByPath(String path);

    void save(Image image);
}
