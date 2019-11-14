package com.theboyaply.orangeJuice.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author theboyaply
 * @version V1.0
 * @Date 2019-11-14
 * @description 文件处理工具
 */
public class FileUtil {

    private static final  Logger log = LoggerFactory.getLogger(FileUtil.class);

    private FileUtil() {}

    /**
     * 上传文件
     *
     * @param path               文件路径
     * @param isContainsFileName 路径是否包含文件名
     * @param multipartFile      文件
     * @return 文件的物理路径
     */
    public static String uploadFile(String path, boolean isContainsFileName, MultipartFile multipartFile) {
        if (StringUtils.isEmpty(path) || multipartFile == null || multipartFile.isEmpty()) {
            return null;
        }

        String fileName;
        String filePath;
        if (isContainsFileName) {
            fileName = path.substring(path.lastIndexOf("/") + 1);
            filePath = path.substring(0, path.lastIndexOf("/") + 1);
        } else {
            fileName = UUID.randomUUID().toString().replace("-", "");
            filePath = path;
        }
        // 文件原始名称
        String originalFileName = multipartFile.getOriginalFilename();
        // 添加文件后缀
        fileName = fileName + originalFileName.substring(originalFileName.lastIndexOf("."));

        // 文件夹不存在则创建
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }

        // 构造上传文件路径
        File uploadFile = new File(filePath + fileName);
        if (uploadFile.exists()) {
            return null;
        }
        try {
            multipartFile.transferTo(uploadFile);
            log.info("上传文件成功");
        } catch (IOException e) {
            log.info("上传文件失败");
            log.info(e.getMessage());
            log.info(e.toString());
        }
        return filePath + fileName;
    }
}
