package ru.skypro.homework.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.entity.PhotoEntity;
import ru.skypro.homework.repository.PhotoRepository;
import ru.skypro.homework.service.PhotoService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PhotoServiceImpl implements PhotoService {
    private final PhotoRepository photoRepository;
    @Value("${path.to.photos.folder}")
    private String photosDir;

    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public String uploadImage(MultipartFile image, String type) throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yy-hh-mm-ss");
        LocalDateTime dateTime = LocalDateTime.now();
        File file = new File(photosDir + type + "/" + dtf.format(dateTime) + "." + getExtension(image.getOriginalFilename()));
        System.out.println(file);

        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(image.getBytes());
        }
        PhotoEntity photoEntity = new PhotoEntity();
        System.out.println(photosDir + image.getName());
        photoEntity.setFilePath(photosDir + file.getName());
        photoEntity.setFileSize(image.getSize());
        photoEntity.setMediaType(image.getContentType());
        photoRepository.save(photoEntity);
        return photoEntity.getFilePath();
    }

    @Override
    public byte[] downloadImage(int id) {
        return new byte[0];
    }

    private String getFileName(String fileName) {
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}
