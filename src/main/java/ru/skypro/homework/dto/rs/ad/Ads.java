package ru.skypro.homework.dto.rs.ad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ads {
    private Integer count;
    private List<Ad> results;
}
