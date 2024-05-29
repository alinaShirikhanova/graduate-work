package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import ru.skypro.homework.dto.rq.ad.CreateOrUpdateAd;
import ru.skypro.homework.dto.rs.ad.Ad;
import ru.skypro.homework.dto.rs.ad.Ads;
import ru.skypro.homework.dto.rs.ad.ExtendedAd;
import ru.skypro.homework.service.AdService;

import java.io.IOException;

import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("ads")
public class AdController {
    private final AdService adService;

    /**
     * Добавление объявления {@code createAd}
     * @param properties свойства объявления
     * @param image медиа файл объявления
     * @return {@code ResponseEntity.ok(new Ad())} объявление добавилось
     */
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> createAd(@RequestPart(value = "properties", required = false) CreateOrUpdateAd properties, @RequestPart("image") MultipartFile image) throws IOException {
        return ResponseEntity.ok(adService.createAd(properties, image));
    }

    /**
     * Получение всех объявлений {@code getAds}
     * @return {@code ResponseEntity.ok(new Ads())} все объявления
     */
    @GetMapping
    public ResponseEntity<?> getAds() {
        return ResponseEntity.ok(adService.getAllAds());
    }

    /**
     * Получение информации об объявлении {@code getAdById}
     * @param id объявления
     * @return {@code ResponseEntity.ok(new ExtendedAd())} информация об объявлении
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getAdById(@PathVariable("id") Integer id) {
        ExtendedAd extendedAd = adService.getInfoById(id);
        if (extendedAd != null) {
            return ResponseEntity.ok(extendedAd);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    /**
     * Удаление объявления {@code deleteById}
     * @param id объявления
     * @return {@code ResponseEntity.ok().build()} код ответа сервера {@code №200, №401, №403, №404}.
     */

    @DeleteMapping("/{id}")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        adService.deleteAdById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    /**
     * Обновление информации об объявлении {@code getAdById}
     * @param id объявления
     * @param createOrUpdateAd измененные свойства объявления
     * @return {@code ResponseEntity.ok(new Ad())} обновленное объявление
     */
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateAd(@PathVariable("id") Integer id, @RequestBody CreateOrUpdateAd createOrUpdateAd) {
        return ResponseEntity.ok(adService.updateAdById(id, createOrUpdateAd));
    }

    /**
     * Получение объявлений авторизованного пользователя {@code getMe}
     * @return {@code ResponseEntity.ok(new Ads())} количество объявлений пользователя, все объявления пользователя
     */
    @GetMapping("/me")
    public ResponseEntity<Ads> getAdsByUser(Authentication authentication) {
        return ResponseEntity.ok(adService.getAdsByUser(authentication.getName()));
    }

//    /**
//     * Обновление картинки объявления {@code getAdById}
//     * @param adId объявления
//     * @param image картинки объявление пользователем
//     * @return {@code ResponseEntity.ok(new User())} обновленное изображение объявления
//     */
//    @PatchMapping(value ="/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<?> updateImage(@PathVariable("id") Integer adId, @RequestPart MultipartFile image) throws IOException {
//        adService.updateImage(adId, image);
//        return ResponseEntity.ok().build();
//    }
    @GetMapping(value = "images/ad/{photoId}", produces = {IMAGE_JPEG_VALUE, IMAGE_PNG_VALUE})
    public ResponseEntity<byte[]> getImage(@PathVariable("photoId") int photoId) throws IOException {
        System.out.println(photoId);
        return ResponseEntity.ok(adService.getImageByAdId(photoId));
    }


}
