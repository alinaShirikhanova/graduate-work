package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.rq.user.NewPassword;
import ru.skypro.homework.dto.rq.user.UpdateUser;
import ru.skypro.homework.dto.rs.user.User;
import ru.skypro.homework.entity.UserEntity;

public interface UserService {
    void updatePassword(NewPassword newPassword);

    User getUser();

    UpdateUser updateUser(UpdateUser updateUser, String name);

    void updateAvatarOfUser(MultipartFile image, Authentication authentication);
}
