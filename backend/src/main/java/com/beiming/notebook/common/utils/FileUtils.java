package com.beiming.notebook.common.utils;


import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * FileUtils
 */
public class FileUtils {

    /**
     * 生成文件名
     */
    public static String getFilename(String file) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        if (StringUtils.isNotBlank(file) && file.contains(".")) {
            int lastIndex = file.lastIndexOf(".");
            String fileSuffix = file.substring(lastIndex);
            return uuid + fileSuffix;
        } else {
            return uuid;
        }
    }

}
