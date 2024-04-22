package ru.skypro.homework.dto.rs.ad;

import lombok.Data;

@Data
public class ExtendedAd {
    /**
     * Поля относящиеся к сущности AdEntity
     */
    private Integer pk;
    private String description;
    private String image;
    private Integer price;
    private String title;
    private String authorFirstName;
    private String authorLastName;
    private String email;
    private String phone;
}
