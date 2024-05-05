package ru.skypro.homework.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import ru.skypro.homework.dto.rq.user.NewPassword;
import ru.skypro.homework.dto.rq.user.UpdateUser;
import ru.skypro.homework.service.UserService;


import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@Slf4j
@CrossOrigin
@RestController

@RequestMapping("users")
public class UserController {
   private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/set_password")
    public ResponseEntity<?> setPassword(@RequestBody NewPassword newPassword, Authentication authentication) {
        service.updatePassword(newPassword, authentication.getName());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/me")
    public ResponseEntity<?> getUser(Authentication authentication) {
        return ResponseEntity.ok(service.getUser(authentication.getName()));
    }

    @PatchMapping("/me")
    public ResponseEntity<?> updateUser(@RequestBody UpdateUser updateUser, Authentication authentication) {
        return ResponseEntity.ok(service.updateUser(updateUser, authentication.getName()));
    }

    @PatchMapping(value = "/me/image", consumes = MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateAvatarOfUser(@RequestParam MultipartFile image, Authentication authentication) {
        service.updateAvatarOfUser(image, authentication);
        return ResponseEntity.ok().build();
    }
}
