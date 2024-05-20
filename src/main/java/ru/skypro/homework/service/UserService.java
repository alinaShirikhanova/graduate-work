package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.rq.user.NewPassword;
import ru.skypro.homework.dto.rq.user.UpdateUser;
import ru.skypro.homework.dto.rs.user.User;
import ru.skypro.homework.entity.UserEntity;

import java.io.IOException;

public interface UserService {
    void updatePassword(NewPassword newPassword);

    void setPassword(NewPassword newPassword, String username);

    User getUser();

    UpdateUser updateUser(UpdateUser updateUser);

    void updateAvatarOfUser(MultipartFile image) throws IOException;

    UserEntity getCurrentUser();
}
