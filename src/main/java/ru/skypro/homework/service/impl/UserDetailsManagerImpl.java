package ru.skypro.homework.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import ru.skypro.homework.entity.UserEntity;
import ru.skypro.homework.exception.UserNotFoundException;
import ru.skypro.homework.repository.UserRepository;
@Service
public class UserDetailsManagerImpl implements UserDetailsManager {

    private final UserRepository repository;

    public UserDetailsManagerImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createUser(UserDetails user) {
        repository.save((UserEntity) user);
    }

    public void updateUser(UserDetails user) {
        repository.save((UserEntity) user);
    }
    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String username, String newPassword) {
        repository.findByUsername(username).ifPresent(userEntity -> {
            userEntity.setPassword(newPassword);
            repository.save(userEntity);
        });
    }

    @Override
    public boolean userExists(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(""));

    }
}
