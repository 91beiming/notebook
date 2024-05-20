package com.beiming.notebook.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.beiming.notebook.dao.model.PhotoAlbum;
import org.apache.ibatis.annotations.Mapper;

/**
 * PhotoAlbumMapper
 */
@Mapper
public interface PhotoAlbumMapper extends BaseMapper<PhotoAlbum> {
    void togglePublic(Long id);
}