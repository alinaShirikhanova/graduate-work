package ru.skypro.homework.util.entity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skypro.homework.entity.RoleEntity;
import ru.skypro.homework.entity.UserEntity;
import ru.skypro.homework.exception.NotFoundException;
import ru.skypro.homework.repository.RoleRepository;
import ru.skypro.homework.util.EntityEnum;
import ru.skypro.homework.util.response.ResponseUtil;

@Service
@RequiredArgsConstructor
public class RoleUtil {
    private final RoleRepository repository;

    public RoleEntity findByName(String name) {
        return repository
                .findByName(name)
                .orElseThrow(() -> new NotFoundException(
                        ResponseUtil.getNotFoundDescription(EntityEnum.ROLE_ENTITY, "name", name)
                ));
    }
}
