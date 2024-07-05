package ru.accelerator.sdt.gateway.services.interf;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    String uploadImage(MultipartFile file);
    MultipartFile downloadImage(String fileName);
    List<String> userImages(Integer userId);
}
