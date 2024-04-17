package ru.skypro.homework.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.Comment;
import ru.skypro.homework.dto.Comments;
import ru.skypro.homework.dto.CreateOrUpdateComment;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/ads")
public class CommentController {

    @GetMapping("/{id}/comments")
    public ResponseEntity<Comments> getComments(@PathVariable("id") Integer id, Authentication authentication) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }


    @PostMapping(value = "/{id}/comments")
    public ResponseEntity<?> addComment(@PathVariable("id") Integer id, @RequestBody CreateOrUpdateComment createOrUpdateComment, Authentication authentication) {
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{adId}/comments/{commentId}")
    @PreAuthorize(value = "hasRole('ADMIN') or @adServiceImpl.isAuthorAd(authentication.getName(), #adId)")
    public ResponseEntity<?> deleteComment(@PathVariable("adId") Integer adId,
                                           @PathVariable("commentId") Integer commentId,
                                           Authentication authentication) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }


    @PatchMapping("/{adId}/comments/{commentId}")
    @PreAuthorize(value = "hasRole('ADMIN') or @adServiceImpl.isAuthorAd(authentication.getName(), #adId)")
    public ResponseEntity<?> updateComment(@PathVariable("adId") Integer adId,
                                           @PathVariable("commentId") Integer commentId,
                                           @RequestBody CreateOrUpdateComment createOrUpdateComment,
                                           Authentication authentication) {
        return ResponseEntity.ok(new Comment());
    }

}