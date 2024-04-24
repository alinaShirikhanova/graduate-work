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

import java.io.IOException;

@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("ads")
public class AdController {
    @GetMapping
    public ResponseEntity<?> getAllAds() {
        return ResponseEntity.ok(new Ads());
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> createAd(@RequestPart(value = "properties", required = false) CreateOrUpdateAd properties,
                                      @RequestPart("image") MultipartFile image) {
        return ResponseEntity.ok(new Ad());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getAdById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(new ExtendedAd());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeAdById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateAd(@PathVariable("id") Integer id, @RequestBody CreateOrUpdateAd dto) {
        return ResponseEntity.ok(new Ad());
    }


    @GetMapping("/me")
    public ResponseEntity<Ads> getMyAds() {
            return ResponseEntity.ok(new Ads());
        }


    @PatchMapping(value = "/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateImage(@PathVariable("id") Integer adId,
                                         @RequestPart MultipartFile image) {
        return ResponseEntity.ok().build();
    }
}
