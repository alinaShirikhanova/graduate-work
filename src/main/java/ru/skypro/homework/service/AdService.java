package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.rq.ad.CreateOrUpdateAd;
import ru.skypro.homework.dto.rs.ad.Ad;
import ru.skypro.homework.dto.rs.ad.Ads;
import ru.skypro.homework.dto.rs.ad.ExtendedAd;
import ru.skypro.homework.entity.AdEntity;

import java.io.IOException;

public interface AdService {
    Ads getAllAds();

    ExtendedAd getInfoById(Integer id);

    void deleteAdById(Integer id);

    Ad updateAdById(Integer id, CreateOrUpdateAd createOrUpdateAd);

    Ads getAdsByUser(String username);

    AdEntity getAdById(Integer id);


    void updateImage(Integer adId, MultipartFile image) throws IOException;

    Ad createAd(CreateOrUpdateAd properties, MultipartFile image) throws IOException;

    byte[] getImageByAdId(int id) throws IOException;
    boolean isAuthor(String username, int id);
}
