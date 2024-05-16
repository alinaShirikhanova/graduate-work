package ru.skypro.homework.entity;

import javax.persistence.*;

public class PhotoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "filePath")
    String filePath;

    @Column(name = "fileSize")
    long fileSize;

    @Column(name = "mediaType")
    String mediaType;
    @Lob
    byte[] data;
}
