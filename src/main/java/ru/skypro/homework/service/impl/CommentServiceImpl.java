package ru.skypro.homework.service.impl;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.rq.comment.Comment;
import ru.skypro.homework.dto.rq.comment.CreateOrUpdateComment;
import ru.skypro.homework.dto.rs.comment.Comments;
import ru.skypro.homework.entity.AdEntity;
import ru.skypro.homework.entity.CommentEntity;
import ru.skypro.homework.entity.UserEntity;
import ru.skypro.homework.exception.AdNotFoundException;
import ru.skypro.homework.exception.CommentNotFoundException;
import ru.skypro.homework.mapper.CommentMapper;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.repository.CommentRepository;
import ru.skypro.homework.service.AdService;
import ru.skypro.homework.service.CommentService;
import ru.skypro.homework.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@Service
//public class CommentServiceImpl implements CommentService {
//    private final UserService userService;
//    private final AdService adService;
//
//    private final CommentRepository commentRepository;
//    private final AdRepository adRepository;
//    private final CommentMapper mapper;
//
//    public CommentServiceImpl(UserService userService, AdService adService, CommentRepository commentRepository, AdRepository adRepository, CommentMapper commentMapper) {
//        this.userService = userService;
//        this.adService = adService;
//
//        this.commentRepository = commentRepository;
//        this.adRepository = adRepository;
//        this.mapper = commentMapper;
//    }
//
//
//
//    @Override
//    public Comments getCommentsByAd(Integer id) {
//        Optional<AdEntity> ad = adRepository.findById(id);
//        if (ad.isPresent()) {
//            List<Comment> comments = ad.get().getComments().stream().map(mapper::commentEntityToComment).collect(Collectors.toList());
//            return new Comments(comments.size(), comments);
//        }
//        throw new AdNotFoundException("Ad not found");
//    }
//
//    @Override
//    public Comment postComment(Integer id, CreateOrUpdateComment createOrUpdateComment) {
//        return saveComment(id, createOrUpdateComment);
//    }
//
//    @Override
//    public void deleteComment(Integer id) {
//        if (commentRepository.existsById(id)) {
//            commentRepository.deleteById(id);
//        }
//        throw new CommentNotFoundException();
//    }
//
//    @Override
//    public Comment updateComment(Integer idAd, Integer idComment, CreateOrUpdateComment createOrUpdateComment) {
//        if (commentRepository.existsById(idComment)) {
//            return saveComment(idAd, createOrUpdateComment);
//        }
//        throw new CommentNotFoundException("Comment not found");
//    }
//
//
//    private CommentEntity getCommentId(Integer id) {
//        return commentRepository.findById(id).orElseThrow();
//    }
//
//
//    private Comment saveComment(Integer adId, CreateOrUpdateComment createOrUpdateComment) {
//        UserEntity user = userService.getCurrentUser();
//        AdEntity adEntity = adService.getAdById(adId);
//        CommentEntity commentEntity = mapper.createOrUpdateCommentToCommentEntity(createOrUpdateComment);
//        commentEntity.setAuthor(user).setAd(adEntity);
//        commentRepository.save(commentEntity);
//        return mapper.commentEntityToComment(commentEntity);
//    }
//}
