package ru.skypro.homework.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Calendar;


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


    @Column(name = "createdAt", nullable = false, updatable = false, insertable = false)
    private Long createdAt = OffsetDateTime.now().toEpochSecond();

    @Column(name="text")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private UserEntity author;
}
