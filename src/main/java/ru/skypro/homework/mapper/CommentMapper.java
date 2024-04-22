package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import ru.skypro.homework.entity.CommentEntity;
import ru.skypro.homework.repository.UserRepository;

@Mapper
public abstract class  CommentMapper {
    @Autowired
    UserRepository userRepository;


    public abstract CommentEntity createOrUpdateCommentToCommentEntity(CreateOrUpdateComment createOrUpdateComment);
    public abstract CreateOrUpdateComment commentEntityTocreateOrUpdateComment(CommentEntity commentEntity);
    @Mapping(target = "author", expression = "java(commentEntity.getAuthor().getId())")
    @Mapping(target = "authorImage", expression = "java(commentEntity.getAuthor().getImage())")
    @Mapping(target = "authorFirstName", expression = "java(commentEntity.getAuthor().getFirstName())")
    @Mapping(target = "pk", source = "commentEntity.id")
    public abstract Comment commentEntityToComment(CommentEntity commentEntity);
}
