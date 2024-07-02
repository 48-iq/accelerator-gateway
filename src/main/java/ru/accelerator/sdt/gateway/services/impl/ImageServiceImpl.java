package ru.accelerator.sdt.gateway.services.impl;

import org.springframework.stereotype.Service;
import ru.accelerator.sdt.gateway.services.interf.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

    @Override
    public String uploadImage(byte[] file) {
        return "";
    }

    @Override
    public byte[] downloadImage(String fileName) {
        return new byte[0];
    }
}
