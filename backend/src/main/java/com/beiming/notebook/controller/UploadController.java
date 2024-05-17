package com.beiming.notebook.controller;

import com.beiming.notebook.domain.ImageDTO;
import com.beiming.notebook.service.ImageService;
import com.beiming.notebook.service.UploadService;
import jakarta.annotation.Resource;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * UploadController
 */
@RestController
@RequestMapping("upload")
public class UploadController {

    @Resource
    private UploadService uploadService;

    @Resource
    private ImageService imageService;

    @PostMapping("img")
    public ImageDTO uploadImg(MultipartFile file) throws IOException {

        ImageDTO imageDTO = imageService.getImage(file);
        if (null != imageDTO) {
            return imageDTO;
        } else {
            String thumbPath = "/img" + uploadService.uploadThumb(file);
            String md5 = DigestUtils.md5DigestAsHex(file.getInputStream());
            Long size = file.getSize();
            String path = "/img" + uploadService.upload(file);
            imageService.saveImage(file.getOriginalFilename(), md5, size, path, thumbPath);
            return imageService.getByPath(path);
        }

    }
}
