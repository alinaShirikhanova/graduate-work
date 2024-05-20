package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.entity.PhotoEntity;

import java.io.IOException;

public interface PhotoService {
    PhotoEntity uploadImage(MultipartFile image, String type) throws IOException;

    byte[] downloadImage(Integer id) throws IOException;
}
