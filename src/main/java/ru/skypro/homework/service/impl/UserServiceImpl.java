package ru.skypro.homework.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.rq.user.NewPassword;
import ru.skypro.homework.dto.rq.user.UpdateUser;
import ru.skypro.homework.dto.rs.user.User;
import ru.skypro.homework.entity.UserEntity;
//import ru.skypro.homework.exception.ReusePasswordException;
import ru.skypro.homework.exception.ReusePasswordException;
import ru.skypro.homework.exception.UserNotFoundException;
import ru.skypro.homework.exception.WrongPasswordException;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository repository, UserMapper mapper, PasswordEncoder encoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.encoder = encoder;
    }


    public void updatePassword(NewPassword newPassword, String username) {
        System.out.println("update");
        UserEntity user = getUserByUsername(username);
        String password = checkPasswords(newPassword, user);
        user.setPassword(encoder.encode(password));
        repository.save(user);
    }
    public void updatePassword(NewPassword newPassword) {
        System.out.println("update");
        UserEntity user = getUserByUsername(getCurrentUsername());
        String password = checkPasswords(newPassword, user);
        user.setPassword(encoder.encode(password));
        repository.save(user);
    }

    @Override
    public User getUser() {
        System.out.println("Зашли");
        UserEntity userEntity = getUserByUsername(getCurrentUsername());
        return mapper.userEntityToUser(userEntity);
    }

    @Override
    public UpdateUser updateUser(UpdateUser updateUser, String username) {
        UserEntity userEntity = getUserByUsername(username);
        userEntity.setFirstName(updateUser.getFirstName());
        userEntity.setLastName(updateUser.getLastName());
        userEntity.setPhone(updateUser.getPhone());
        repository.save(userEntity);
        return mapper.userEntityToUpdateUser(userEntity);
    }

    @Override
    public void updateAvatarOfUser(MultipartFile image, Authentication authentication) {

    }


    private String checkPasswords(NewPassword dto, UserEntity user) {
        String currentPassword = dto.getCurrentPassword();
        String newPassword = dto.getNewPassword();

        if (!encoder.matches(currentPassword, user.getPassword())) {
            throw new WrongPasswordException();

        } else if (encoder.matches(newPassword, user.getPassword())) {
            throw new ReusePasswordException();
        }
        return newPassword;
    }

    private UserEntity getUserByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(UserNotFoundException::new);
    }

    private String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
