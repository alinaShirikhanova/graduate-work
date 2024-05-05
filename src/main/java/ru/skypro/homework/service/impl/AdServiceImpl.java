package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.rs.ad.Ad;
import ru.skypro.homework.dto.rs.ad.Ads;
import ru.skypro.homework.mapper.AdMapper;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.service.AdService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdServiceImpl implements AdService {
    private final AdRepository repository;
    private final AdMapper mapper;

    public AdServiceImpl(AdRepository repository, AdMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Ads getAllAds() {
        List<Ad> ads = repository.findAll().stream()
                .map(mapper::adEntityToAd)
                .collect(Collectors.toList());

        return new Ads(ads.size(), ads);
    }
}
