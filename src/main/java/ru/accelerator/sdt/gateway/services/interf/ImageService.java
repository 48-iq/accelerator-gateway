package ru.accelerator.sdt.gateway.services.interf;

public interface ImageService {
    String uploadImage(byte[] file);
    byte[] downloadImage(String fileName);
}
