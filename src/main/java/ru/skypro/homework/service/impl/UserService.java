package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.rq.user.NewPassword;
import ru.skypro.homework.entity.UserEntity;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    public UserService(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void updatePassword(NewPassword newPassword) {
        UserEntity user = getUser();
        String password = checkPasswords(dto, user);
        user.setPassword(encoder.encode(password));
        userRepository.save(user);
        return true;
    }
}
