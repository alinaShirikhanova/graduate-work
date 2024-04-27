package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ru.skypro.homework.dto.rq.user.Register;
import ru.skypro.homework.dto.rq.user.Role;
import ru.skypro.homework.dto.rq.user.UpdateUser;
import ru.skypro.homework.dto.rs.user.User;
import ru.skypro.homework.entity.RoleEntity;
import ru.skypro.homework.entity.UserEntity;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    @Mapping(target="email", source = "username")
    @Mapping(target="role", expression = "java(getRole(userEntity))")
    abstract User userToUserEntity(UserEntity userEntity);

    abstract UserEntity updateUserToUserEntity(UpdateUser updateUser);
    abstract UpdateUser userEntityToUpdateUser(UserEntity userEntity);

    public abstract UserEntity registerToUserEntity(Register register);

    @Mapping(target = "name", expression = "java(role.name())")
    abstract RoleEntity roleToRoleEntity(Role role);

    public static Role getRole(UserEntity userEntity){
        return Role.valueOf(userEntity.getRole().getName());
    }
}