package ru.skypro.homework.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;


import javax.persistence.*;
import java.util.List;


@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(schema = "public", name = "ads")
public class AdEntity {
    /**
     * Id объявления
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Медиа файл объявления
     */
    @OneToOne
    @JoinColumn(name = "image_id")
    private PhotoEntity image;

    /**
     * Цена объявления
     */
    @Column(name = "price", nullable = false)
    private Integer price;

    /**
     * Название объявления
     */
    @Column(name = "title", nullable = false)
    private String title;

    /**
     * Описание объявления
     */
    @Column(name = "description", nullable = false)
    private String description;

    /**
     * Автор объявления
     */
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private UserEntity author;

    @JsonIgnore
    @OneToMany(mappedBy = "ad", fetch = FetchType.LAZY)
    private List<CommentEntity> comments;
}
