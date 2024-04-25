package ru.skypro.homework.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;


import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(schema = "graduate", name = "users")
public class UserEntity {
    /**
     * Id пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Логин пользователя
     */
    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;
    /**
     * Имя пользователя
     */
    @Column(name = "first_name", nullable = false)
    private String firstName;

    /**
     * Фамилия пользователя
     */
    @Column(name = "last_name", nullable = false)
    private String lastName;

    /**
     * Телефон пользователя
     */
    @Column(name = "phone", nullable = false)
    private String phone;

    /**
     * Ссылка на аватар пользователя
     */
    @Column(name = "image")
    private String image;

    /**
     * Комментарии пользователя
     */
    @JsonIgnore
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private Set<CommentEntity> comments;

    /**
     * Объявления пользователя
     */
    @JsonIgnore
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private Set<AdEntity> ads;

    /**
     * Роль пользователя
     */
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private RoleEntity role;
}