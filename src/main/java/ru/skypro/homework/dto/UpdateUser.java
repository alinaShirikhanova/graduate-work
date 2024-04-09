package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class UpdateUser {
    private String username;
    private String phone;
    private String firstName;
}