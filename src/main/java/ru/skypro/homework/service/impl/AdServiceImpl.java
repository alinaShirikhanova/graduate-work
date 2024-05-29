package ru.skypro.homework.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.rq.ad.CreateOrUpdateAd;
import ru.skypro.homework.dto.rs.ad.Ad;
import ru.skypro.homework.dto.rs.ad.Ads;
import ru.skypro.homework.dto.rs.ad.ExtendedAd;
import ru.skypro.homework.entity.AdEntity;
import ru.skypro.homework.entity.PhotoEntity;
import ru.skypro.homework.entity.UserEntity;
import ru.skypro.homework.exception.AdNotFoundException;
import ru.skypro.homework.mapper.AdMapper;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.AdService;
import ru.skypro.homework.service.PhotoService;
import ru.skypro.homework.service.UserService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
public class AdServiceImpl implements AdService {
    private final AdRepository adRepository;
    private final AdMapper mapper;
    private final UserService userService;

    private final PhotoService photoService;


    public AdServiceImpl(AdRepository adRepository, AdMapper mapper, UserService userService, PhotoService photoService) {
        this.adRepository = adRepository;
        this.mapper = mapper;
        this.userService = userService;
        this.photoService = photoService;
    }

    @Override
    public Ads getAllAds() {
        List<Ad> ads = adRepository.findAll().stream()
                .map(mapper::adEntityToAd)
                .collect(Collectors.toList());

        return new Ads(ads.size(), ads);
    }

    @Override
    public ExtendedAd getInfoById(Integer id) {
        Optional<AdEntity> awd = adRepository.findById(id);
        if (awd.isEmpty()) {
            throw new AdNotFoundException("Not found ad");
        }
        return mapper.adEntityToExtendedAd(awd.get());
    }

    @Override
    public void deleteAdById(Integer id) {
        Optional<AdEntity> awd = adRepository.findById(id);
        if (awd.isEmpty()) {
            throw new AdNotFoundException();
        }
        adRepository.deleteById(id);
    }

    @Override
    public Ad updateAdById(Integer id, CreateOrUpdateAd createOrUpdateAd) {
        Optional<AdEntity> adEntityOptional = adRepository.findById(id);
        if (adEntityOptional.isPresent()) {
            AdEntity adEntity = adEntityOptional.get();
            adEntity.setTitle(createOrUpdateAd.getTitle());
            adEntity.setDescription(createOrUpdateAd.getDescription());
            adEntity.setPrice(createOrUpdateAd.getPrice());
            adRepository.save(adEntity);
            return mapper.adEntityToAd(adEntity);
        }
        throw new AdNotFoundException("Not found ad");
    }

    @Override
    public Ads getAdsByUser(String username) {
        UserEntity userEntity = userService.getCurrentUser();
        List<Ad> adList = userEntity.getAds().stream().map(mapper::adEntityToAd).collect(Collectors.toList());
        return new Ads(adList.size(), adList);
    }

    @Override
    public AdEntity getAdById(Integer id) {
        return adRepository.findById(id).orElseThrow(AdNotFoundException::new);
    }

    public void updateImage(Integer adId, MultipartFile image) throws IOException {
        AdEntity adEntity = getAdById(adId);
        adEntity.setImage("images/ad/" + photoService.uploadImage(image, "photos").getId());
        adRepository.save(adEntity);
    }

    @Override
    public Ad createAd(CreateOrUpdateAd createOrUpdateAd, MultipartFile image) throws IOException {
        AdEntity adEntity = mapper.createOrUpdateAdToAdEntity(createOrUpdateAd);
        Integer photoId = photoService.uploadImage(image, "photos").getId();
        UserEntity user = userService.getCurrentUser();
        adEntity.setAuthor(user);
        adEntity.setImage("images/ad/" + photoId);
        adRepository.save(adEntity);
        return mapper.adEntityToAd(adEntity);
    }

    @Override
    public byte[] getImageByAdId(int photoId) throws IOException {
        return photoService.downloadImage(photoId);
    }


}
