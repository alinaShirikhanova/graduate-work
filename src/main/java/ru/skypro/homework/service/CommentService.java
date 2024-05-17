package ru.skypro.homework.service;

import org.springframework.security.access.prepost.PreAuthorize;
import ru.skypro.homework.controller.CommentController;
import ru.skypro.homework.dto.rq.comment.Comment;
import ru.skypro.homework.dto.rq.comment.CreateOrUpdateComment;
import ru.skypro.homework.dto.rs.comment.Comments;

public interface CommentService {

    Comments getCommentsByAd(Integer id);

    Comment postComment(Integer id, CreateOrUpdateComment createOrUpdateComment);

    void deleteComment(Integer id);

    @PreAuthorize(value = "")
    Comment updateComment(Integer idAd, Integer idComment, CreateOrUpdateComment createOrUpdateComment);
}
