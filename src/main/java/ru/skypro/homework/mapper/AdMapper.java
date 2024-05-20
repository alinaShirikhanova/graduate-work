package ru.skypro.homework.mapper;

import  org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.skypro.homework.dto.rq.ad.CreateOrUpdateAd;
import ru.skypro.homework.dto.rs.ad.Ad;
import ru.skypro.homework.dto.rs.ad.ExtendedAd;
import ru.skypro.homework.entity.AdEntity;

@Mapper(componentModel = "spring")
public interface AdMapper {
    CreateOrUpdateAd adEntityToCreateOrUpdateAd(AdEntity adEntity);

    @Mapping(target = "author", expression = "java(adEntity.getAuthor().getId())")
    Ad adEntityToAd(AdEntity adEntity);

    AdEntity createOrUpdateAdToAdEntity(CreateOrUpdateAd createOrUpdateAd);

    @Mapping(target = "authorFirstName", expression = "java(adEntity.getAuthor().getFirstName())")
    @Mapping(target = "authorLastName", expression = "java(adEntity.getAuthor().getLastName())")
    @Mapping(target = "email", expression = "java(adEntity.getAuthor().getUsername())")
    @Mapping(target = "phone", expression = "java(adEntity.getAuthor().getPhone())")
    ExtendedAd adEntityToExtendedAd(AdEntity adEntity);
}
