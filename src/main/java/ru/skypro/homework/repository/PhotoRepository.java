package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.entity.PhotoEntity;

public interface PhotoRepository extends JpaRepository<PhotoEntity, Integer> {
    PhotoEntity findByFilePath(String filePath);
}
