package ru.skypro.homework.dto.rs.ad;

import lombok.Data;

import java.util.List;

@Data
public class Ads {
    private Integer count;
    private List<Ad> results;
}
