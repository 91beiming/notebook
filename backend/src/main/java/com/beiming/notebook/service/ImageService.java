package com.beiming.notebook.service;

import com.beiming.notebook.domain.ImageDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * FileService
 */
public interface ImageService {

    ImageDTO getImage(MultipartFile file) throws IOException;

    void saveImage(String originFilename, String md5, Long size, String path, String thumbPath) throws IOException;

    ImageDTO getByPath(String path);
}
