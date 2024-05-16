package ru.skypro.homework.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(schema = "public", name = "photo")
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
