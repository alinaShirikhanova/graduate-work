package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.service.PhotoService;

import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RequiredArgsConstructor
@RequestMapping("/images")
@RestController
public class PhotoController {

    private final PhotoService photoService;
    @GetMapping(value = "/ad/{id}", produces = {IMAGE_JPEG_VALUE, IMAGE_PNG_VALUE})
    public ResponseEntity<byte[]> getImage(@PathVariable int id) {
        return ResponseEntity.ok(photoService.downloadImage(id));
    }
}
