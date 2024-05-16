package ru.skypro.homework.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.entity.AdEntity;
import ru.skypro.homework.entity.PhotoEntity;
import ru.skypro.homework.exception.AdNotFoundException;
import ru.skypro.homework.repository.PhotoRepository;
import ru.skypro.homework.service.PhotoService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
public class PhotoServiceImpl implements PhotoService {
    private final PhotoRepository photoRepository;
    @Value("${path.to.photos.folder}")
    private String photosDir;

    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public PhotoEntity uploadImage(MultipartFile image) throws IOException {
        File file = new File(photosDir + LocalDate.now() + "." + getExtensions(image.getOriginalFilename()));
        System.out.println(file);

        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(image.getBytes());
        }
//        Path filePath = Path.of(photosDir );
//        Files.createDirectories(filePath.getParent());
//        Files.deleteIfExists(filePath);
//        try (
//                InputStream is = image.getInputStream();
//                OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
//                BufferedInputStream bis = new BufferedInputStream(is, 1024);
//                BufferedOutputStream bos = new BufferedOutputStream(os, 1024);
//        ) {
//            bis.transferTo(bos);
//        }

//        Path filePath = Path.of(photosDir, image.getName() + LocalDate.now() + "." + getExtensions(image.getOriginalFilename()));
//        Files.createDirectories(filePath.getParent());
//        Files.deleteIfExists(filePath);
//        try (
//                InputStream is = image.getInputStream();
//                OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
//                BufferedInputStream bis = new BufferedInputStream(is, 1024);
//                BufferedOutputStream bos = new BufferedOutputStream(os, 1024);
//        ) {
//            bis.transferTo(bos);
//        }
        PhotoEntity photoEntity = new PhotoEntity();
        System.out.println(photosDir + image.getName());
        photoEntity.setFilePath(photosDir + image.getName());
        photoEntity.setFileSize(image.getSize());
        photoEntity.setMediaType(image.getContentType());
        photoRepository.save(photoEntity);


//        Path path = Paths.get(photosDir, image.getName());
//        Path file = Files.createFile(path);
//        FileOutputStream stream = null;
//        try {
//            stream = new FileOutputStream(file.toString());
//            stream.write(image.getBytes());
//        } finally {
//            stream.close();
//        }
        return photoEntity;
    }

    private String getExtensions(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}
