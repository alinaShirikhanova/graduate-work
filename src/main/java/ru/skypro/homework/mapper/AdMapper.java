package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import ru.skypro.homework.dto.CreateOrUpdateAd;
import ru.skypro.homework.entity.AdEntity;

@Mapper(componentModel = "spring")
public interface AdMapper {
    CreateOrUpdateAd createOrUpdateAdToAdEntity(AdEntity adEntity);
    AdEntity AdEntityToCreateOrUpdateAd(CreateOrUpdateAd createOrUpdateAd);


}
