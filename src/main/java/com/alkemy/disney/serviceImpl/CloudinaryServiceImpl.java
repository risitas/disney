package com.alkemy.disney.serviceImpl;

import com.alkemy.disney.service.CloudinaryService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CloudinaryServiceImpl implements CloudinaryService {

    private final Cloudinary cloudinary;

    public CloudinaryServiceImpl(){
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "daidr3a2a");
        config.put("api_key", "767786646536961");
        config.put("api_secret", "a_kYkhfe9SnRf-3D42IEpIC70AQ");
        cloudinary = new Cloudinary(config);
    }

    @Override
    public Map upImage(File file, String folder) throws Exception {
        return cloudinary.uploader().upload(file, ObjectUtils.asMap("folder",
                String.format(folder)));
    }

    @Override
    public Map deleteImage(String idImage) throws Exception {
        return cloudinary.uploader().destroy("disney/"+idImage, ObjectUtils.emptyMap());
    }

    @Override
    public File convert(MultipartFile image) throws IOException {
        File file = File.createTempFile(image.getOriginalFilename(), null);
        System.out.println(image.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(image.getBytes());
        fos.close();
        return file;
    }
}
