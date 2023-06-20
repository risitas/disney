package com.alkemy.disney.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface CloudinaryService {

    Map upImage(File file, String folder) throws Exception;
    Map deleteImage(String idImage) throws Exception;
    File convert(MultipartFile image) throws IOException;
}
