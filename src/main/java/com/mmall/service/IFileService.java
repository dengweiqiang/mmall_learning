package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by dengweiqiang on 2020/1/4
 */
public interface IFileService {
    String upload(MultipartFile file, String path);
}
