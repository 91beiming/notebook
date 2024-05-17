package com.beiming.notebook.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * UploadService
 */
public interface UploadService {


    String upload(MultipartFile file) throws IOException;

    String uploadThumb(MultipartFile file) throws IOException;


}
