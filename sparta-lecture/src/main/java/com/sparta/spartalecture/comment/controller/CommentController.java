package com.sparta.spartalecture.comment.controller;

import com.sparta.spartalecture.comment.dto.CommentCreateRequestDto;
import com.sparta.spartalecture.comment.dto.CommentUpdateRequestDto;
import com.sparta.spartalecture.comment.service.CommentService;
import com.sparta.spartalecture.security.service.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/lectures/{lectureId}/comments")
    public ResponseEntity<Void> createComment(@RequestBody CommentCreateRequestDto requestDto,
                                              @PathVariable Long lectureId,
                                              @AuthenticationPrincipal UserDetailsImpl userDetails) {
        commentService.createComment(requestDto, lectureId, userDetails);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/lectures/comments/{commentId}")
    public ResponseEntity<Void> updateComment(@RequestBody CommentUpdateRequestDto requestDto,
                                              @PathVariable Long commentId,
                                              @AuthenticationPrincipal UserDetailsImpl userDetails) {
        commentService.updateComment(requestDto, commentId, userDetails);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/lectures/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId,
                                              @AuthenticationPrincipal UserDetailsImpl userDetails) {
        commentService.deleteComment(commentId, userDetails);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
