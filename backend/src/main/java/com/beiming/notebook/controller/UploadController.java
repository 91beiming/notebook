package com.beiming.notebook.controller;

import com.beiming.notebook.common.exception.CustomerException;
import com.beiming.notebook.service.ImageService;
import com.beiming.notebook.service.UploadService;
import com.beiming.notebook.service.model.ImageDTO;
import jakarta.annotation.Resource;
import org.springframework.http.MediaTypeFactory;
import org.springframework.util.DigestUtils;
import org.springframework.util.MimeType;
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

    /**
     * 上传图片
     *
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("img")
    public ImageDTO uploadImg(MultipartFile file) throws IOException {
        //检测文件类型
        Boolean isImg = MediaTypeFactory.getMediaType(file.getOriginalFilename())
                .map(MimeType::getType)
                .map("image"::equals)
                .orElse(false);
        if (!isImg) {
            throw new CustomerException("文件类型不符合");
        }


        //先查询文件库中有无当前文件
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
