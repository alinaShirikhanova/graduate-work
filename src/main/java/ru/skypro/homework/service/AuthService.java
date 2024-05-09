package ru.skypro.homework.service;

import ru.skypro.homework.dto.rq.user.Register;

import java.util.Optional;

public interface AuthService {
    boolean login(String userName, String password);

    boolean register(Register register);
}
