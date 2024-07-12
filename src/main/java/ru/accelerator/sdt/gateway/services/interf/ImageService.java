package ru.accelerator.sdt.gateway.services.interf;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    String saveImage(MultipartFile file);
    MultipartFile getImage(String fileName);
    List<MultipartFile> getImages(List<String> fileNames);
    List<String> getImagesByUser(Integer userId);
    void deleteImage(String fileName);
}
