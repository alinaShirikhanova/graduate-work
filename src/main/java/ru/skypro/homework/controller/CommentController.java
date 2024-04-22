package ru.skypro.homework.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.rq.comment.Comment;
import ru.skypro.homework.dto.rq.comment.CreateOrUpdateComment;
import ru.skypro.homework.dto.rs.comment.Comments;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/ads")
public class CommentController {

    @GetMapping("/{id}/comments")
    public ResponseEntity<Comments> getComments(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(new Comments());
    }


    @PostMapping(value = "/{id}/comments")
    public ResponseEntity<?> addComment(@PathVariable("id") Integer id, @RequestBody CreateOrUpdateComment createOrUpdateComment) {
        return ResponseEntity.ok(new Comment());
    }


    @DeleteMapping("/{adId}/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable("adId") Integer adId,
                                           @PathVariable("commentId") Integer commentId) {
        return ResponseEntity.ok().build();
    }


    @PatchMapping("/{adId}/comments/{commentId}")
    public ResponseEntity<?> updateComment(@PathVariable("adId") Integer adId,
                                           @PathVariable("commentId") Integer commentId,
                                           @RequestBody CreateOrUpdateComment createOrUpdateComment,
                                           Authentication authentication) {
        return ResponseEntity.ok(new Comment());
    }
}