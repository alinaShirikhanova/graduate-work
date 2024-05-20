package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoService {
    String uploadImage(MultipartFile image, String type) throws IOException;

    byte[] downloadImage(int id);
}
