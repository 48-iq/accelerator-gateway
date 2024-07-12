package ru.accelerator.sdt.gateway.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import ru.accelerator.sdt.gateway.services.interf.ImageService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final RestTemplate restTemplate;
    @Value("${hosts.services.image}")
    private String imageHost;
    @Value("${mappings.services.image.save")
    private String saveMapping;
    @Value("${mappings.services.image.get")
    private String getMapping;

    @Override
    public String saveImage(MultipartFile file) {
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(imageHost + saveMapping, file, String.class);
            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MultipartFile getImage(String fileName) {
        try {
            ResponseEntity<MultipartFile> response = restTemplate.getForEntity(imageHost + saveMapping, MultipartFile.class);
            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<MultipartFile> getImages(List<String> fileNames) {
        try {
            ResponseEntity<List> response = restTemplate.getForEntity(imageHost + saveMapping, List.class, fileNames.toArray(new String[]{}));
            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> getImagesByUser(Integer userId) {
        try {
            ResponseEntity<List> response = restTemplate.getForEntity(imageHost + saveMapping, List.class, fileNames.toArray(new String[]{}));
            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteImage(String fileName) {

    }
}
