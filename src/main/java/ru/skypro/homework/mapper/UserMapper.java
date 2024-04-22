package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import ru.skypro.homework.dto.Register;
import ru.skypro.homework.dto.Role;
import ru.skypro.homework.entity.RoleEntity;
import ru.skypro.homework.entity.UserEntity;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

//    @Mapping(target = "name", expression = "java(role.name())")
//    public abstract RoleEntity roleToRoleEntity(Role role);
//
//    @Mapping(target = ".", expression = "java(roleEntity.getName())")
//    public abstract Role roleEntityToRole(RoleEntity roleEntity);
}