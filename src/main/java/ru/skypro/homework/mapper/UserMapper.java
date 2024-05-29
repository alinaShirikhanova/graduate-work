package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.springframework.beans.factory.annotation.Autowired;
import ru.skypro.homework.dto.rq.user.Register;
import ru.skypro.homework.dto.rq.user.Role;
import ru.skypro.homework.dto.rq.user.UpdateUser;
import ru.skypro.homework.dto.rs.user.User;
import ru.skypro.homework.entity.UserEntity;
import ru.skypro.homework.util.entity.RoleUtil;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    @Autowired
    RoleUtil roleUtil;

//    @Mapping(target="email", source = "username")
//    @Mapping(target="role", expression = "java(getRole(userEntity))")
//    abstract User userToUserEntity(UserEntity userEntity);

    public abstract UserEntity updateUserToUserEntity(UpdateUser updateUser);
    public abstract UpdateUser userEntityToUpdateUser(UserEntity userEntity);

    @Mapping(target = "role", expression = "java(roleUtil.findByName(register.getRole().name()))")
    public abstract UserEntity registerToUserEntity(Register register);

//    @Mapping(target = "name", expression = "java(role.name())")
//    public abstract RoleEntity roleToRoleEntity(Role role);
    @Mapping(target = "email", source = "username")
    @Mapping(target = "role", expression = "java(getRole(userEntity))")
    public abstract User userEntityToUser(UserEntity userEntity);

    public static Role getRole(UserEntity userEntity){
        return Role.valueOf(userEntity.getRole().getName());
    }
}