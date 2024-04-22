package ru.skypro.homework.dto.rs.user;

import lombok.Data;
import ru.skypro.homework.dto.rq.user.Role;

@Data
public class User {
    /**
     * Поля относящиеся к сущности UserEntity
     */
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String image;
    /**
     * Поля относящиеся к сущности RoleEntity
     */
    private Role role;

}
