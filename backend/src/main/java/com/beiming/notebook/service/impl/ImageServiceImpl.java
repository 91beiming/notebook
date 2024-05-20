package com.beiming.notebook.service.impl;

import com.beiming.notebook.dao.impl.ImageDAO;
import com.beiming.notebook.dao.model.Image;
import com.beiming.notebook.service.model.ImageDTO;
import com.beiming.notebook.service.ImageService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * FileServiceImpl
 */
@Service
public class ImageServiceImpl implements ImageService {

    @Resource
    private ImageDAO imageDAO;

    @Override
    public ImageDTO getImage(MultipartFile file) throws IOException {
        String md5 = DigestUtils.md5DigestAsHex(file.getInputStream());
        long size = file.getSize();
        Image image = imageDAO.getByMd5AndSize(md5, size);
        if (null == image) {
            return null;
        } else {
            return image.clone(ImageDTO.class);
        }
    }

    @Override
    public void saveImage(String originFilename, String md5, Long size, String path, String thumbPath) throws IOException {
        Image image = new Image();
        image.setMd5(md5);
        image.setSize(size);
        image.setPath(path);
        image.setThumbPath(thumbPath);
        image.setOriginFilename(originFilename);
        imageDAO.save(image);
    }

    @Override
    public ImageDTO getByPath(String path) {
        Image image = imageDAO.getByPath(path);
        if (null == image) {
            return null;
        } else {
            return image.clone(ImageDTO.class);
        }
    }
}
