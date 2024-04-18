package ru.skypro.homework.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Setter
@Getter
@Entity

@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(schema = "public", name = "comments")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="created_at")
    private Long createdAt;

    @Column(name="text")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private UserEntity author;
}
