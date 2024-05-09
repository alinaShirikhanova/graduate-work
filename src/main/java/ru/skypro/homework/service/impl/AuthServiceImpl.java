package ru.skypro.homework.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.rq.user.Login;
import ru.skypro.homework.dto.rq.user.Register;
import ru.skypro.homework.entity.UserEntity;
import ru.skypro.homework.exception.WrongPasswordException;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.AuthService;

import java.util.Optional;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserDetailsManager manager;
    private final UserMapper mapper;
    private final PasswordEncoder encoder;
    private final UserRepository repository;

    public AuthServiceImpl(UserDetailsManager manager, UserMapper mapper,
                           PasswordEncoder passwordEncoder, UserRepository repository) {
        this.manager = manager;
        this.mapper = mapper;
        this.encoder = passwordEncoder;
        this.repository = repository;
    }


    @Override
    public boolean login(String userName, String password) {
        log.info("Запущен метод сервиса {}", "login");
        UserDetails userDetails = manager.loadUserByUsername(userName);
        if (!encoder.matches(password, userDetails.getPassword())) {
            throw new WrongPasswordException("Неверный пароль");
        }
        return true;
    }
//    @Override
//    public boolean login(String username, String password) {
//        System.out.println("зашли в логин");
//        if (!manager.userExists(username)) {
//            return false;
//        }
//        UserDetails userDetails = manager.loadUserByUsername(username);
//        if (!encoder.matches(password, userDetails.getPassword()))
//            throw  new WrongPasswordException("Неверный логин");
//        return true;
//    }

    @Override
    public boolean register(Register register) {
        if (manager.userExists(register.getUsername())) {
            return false;
        }

        UserEntity user = mapper.registerToUserEntity(register);
        user.setPassword(encoder.encode(user.getPassword()));
        manager.createUser(user);
        return true;
    }



//    @Override
//    public boolean register(Register dto) {
//        UserEntity user = userMapper.toUserEntity(dto);
//
//        if (userRepository.findUserEntityByUsername(user.getUsername()).isPresent()) {
//            throw new UserAlreadyAddedException();
//        }
//
//        user.setPassword(encoder.encode(user.getPassword()));
//        userRepository.save(user);
//        return true;
//    }
}
