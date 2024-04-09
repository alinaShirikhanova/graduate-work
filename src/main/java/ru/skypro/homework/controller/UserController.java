package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.Login;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.UpdateUser;
import ru.skypro.homework.dto.User;
import ru.skypro.homework.service.AuthService;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {


    @PostMapping("/set_password")
    public ResponseEntity<?> setPassword(@RequestBody NewPassword newPassword) {
        return ResponseEntity.ok(new NewPassword());
    }

    @GetMapping("/me")
    public ResponseEntity<?> getUser() {
        return ResponseEntity.ok(new NewPassword());
    }

    @PatchMapping("/me")
    public ResponseEntity<?> updateUser(@RequestBody UpdateUser updateUser) {
        return ResponseEntity.ok(new UpdateUser());
    }

    @PatchMapping(value = "/me/image", consumes = MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateAvatarOfUser(@RequestParam MultipartFile image) {
        return ResponseEntity.ok(new UpdateUser());
    }
}
