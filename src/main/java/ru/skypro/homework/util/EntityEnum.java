package ru.skypro.homework.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EntityEnum {
    PRIVILEGE_ENTITY("Privilege"),
    ROLE_ENTITY("Role"),
    USER_ENTITY("User"),
    AD_ENTITY("Ad"),
    COMMENT_ENTITY("Comment");
    private final String name;
}
