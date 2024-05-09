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
import ru.skypro.homework.service.AuthService;
import ru.skypro.homework.service.UserService;


import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@Slf4j
@CrossOrigin(value = "http://localhost:8080")
@RestController
@RequestMapping("users")
public class UserController {
   private final UserService service;
   private final AuthService authService;

    public UserController(UserService service, AuthService authService) {
        this.service = service;
        this.authService = authService;
    }

    @PostMapping("/set_password")
    public ResponseEntity<?> setPassword(@RequestBody NewPassword newPassword, Authentication authentication) {
        System.out.println("Controller");
        service.updatePassword(newPassword, authentication.getName());
        return ResponseEntity.ok().build();
    }

//    @PostMapping("/set_password")
//    public NewPassword setPassword(@RequestBody NewPassword newPassword, Authentication authentication) {
//        NewPassword resultPassword = new NewPassword();
//        authService.changePassword(
//                        authentication.getName(),
//                        newPassword.getCurrentPassword(),
//                        newPassword.getNewPassword()
//                )
//                .ifPresent(resultPassword::setCurrentPassword);
//        return resultPassword;
//    }

    @GetMapping("/me")
    public ResponseEntity<?> getUser() {
        return ResponseEntity.ok(service.getUser());
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
