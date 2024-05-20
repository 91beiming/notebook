package com.beiming.notebook.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.beiming.notebook.dao.mapper.ImageMapper;
import com.beiming.notebook.dao.model.Image;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

/**
 * ImageDAOImpl
 */
@Repository
public class ImageDAO {

    @Resource
    private ImageMapper imageMapper;

    public Image getByMd5AndSize(String md5, long size) {
        return imageMapper.selectOne(
                new LambdaQueryWrapper<Image>()
                        .eq(Image::getMd5, md5)
                        .eq(Image::getSize, size)
        );
    }

    public Image getByPath(String path) {
        return imageMapper.selectOne(
                new LambdaQueryWrapper<Image>()
                        .eq(Image::getPath, path)
        );
    }

    public void save(Image image) {
        imageMapper.insert(image);
    }
}
