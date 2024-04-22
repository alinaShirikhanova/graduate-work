package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

//    @Mapping(target = "name", expression = "java(role.name())")
//    public abstract RoleEntity roleToRoleEntity(Role role);
//
//    @Mapping(target = ".", expression = "java(roleEntity.getName())")
//    public abstract Role roleEntityToRole(RoleEntity roleEntity);
}