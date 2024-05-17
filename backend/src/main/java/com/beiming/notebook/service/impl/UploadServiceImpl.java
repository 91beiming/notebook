package com.beiming.notebook.service.impl;

import com.beiming.notebook.common.exception.CustomerException;
import com.beiming.notebook.common.utils.FileUtils;
import com.beiming.notebook.service.UploadService;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * LocalUploadServiceImpl
 */
@Service
public class UploadServiceImpl implements UploadService {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/w");

    @Override
    public String upload(MultipartFile file) throws IOException {

        String subDirStr = "/" + LocalDateTime.now().format(dateTimeFormatter);
        //创建根目录和上级目录
        File subDir = getSubFile(subDirStr);
        //获取文件名
        String filename = FileUtils.getFilename(file.getOriginalFilename());
        //创建目标文件
        File dest = new File(subDir, filename);
        file.transferTo(dest);
        return subDirStr + "/" + filename;
    }

    /**
     * 生成文件的缩略图
     * @param file
     * @return
     * @throws IOException
     */
    @Override
    public String uploadThumb(MultipartFile file) throws IOException {
        String subDirStr = "/" + LocalDateTime.now().format(dateTimeFormatter);
        //创建根目录和上级目录
        File subDir = getSubFile(subDirStr);
        //获取文件名
        String filename = FileUtils.getFilename(file.getOriginalFilename());
        //创建目标文件
        File dest = new File(subDir, filename);
        Thumbnails.of(file.getInputStream())
                .size(300, 300)
                .toFile(dest);
        return subDirStr + "/" + filename;
    }

    /**
     * 创建根目录和上级目录
     */
    private File getSubFile(String subDirStr) {
        File rootDir = new File("/upload").getAbsoluteFile();
        if (!rootDir.exists()) {
            if (!rootDir.mkdirs()) {
                throw new CustomerException("创建上传根目录失败");
            }
        }
        File subDir = new File(rootDir, subDirStr);
        if (!subDir.exists()) {
            if (!subDir.mkdirs()) {
                throw new CustomerException("创建上传上级目录失败" + subDirStr);
            }
        }
        return subDir;
    }
}
