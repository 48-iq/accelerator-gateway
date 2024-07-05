package ru.accelerator.sdt.gateway.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.accelerator.sdt.gateway.services.interf.ImageService;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Override
    public String uploadImage(MultipartFile file) {
        return "";
    }

    @Override
    public MultipartFile downloadImage(String fileName) {
        return null;
    }

    @Override
    public List<String> userImages(Integer userId) {
        return List.of();
    }


}
