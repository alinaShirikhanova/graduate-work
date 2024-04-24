package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.skypro.homework.dto.rq.ad.CreateOrUpdateAd;
import ru.skypro.homework.dto.rs.ad.Ad;
import ru.skypro.homework.entity.AdEntity;

@Mapper(componentModel = "spring")
public interface AdMapper {
    CreateOrUpdateAd createOrUpdateAdToAdEntity(AdEntity adEntity);

    @Mapping(target = "author", expression = "java(adEntity.getAuthor().getId())")
    Ad adEntityToAd(AdEntity adEntity);

    AdEntity createOrUpdateAdToCommentEntity(CreateOrUpdateAd createOrUpdateAd);
}
