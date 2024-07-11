package com.sparta.spartalecture.like.controller;

import com.sparta.spartalecture.like.service.LikeLectureService;
import com.sparta.spartalecture.security.service.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LikeLectureController {

    private final LikeLectureService likeLectureService;

    @PostMapping("/lectures/{lectureId}/like")
    public ResponseEntity<Void> toggleLike(@PathVariable Long lectureId,
                                           @AuthenticationPrincipal UserDetailsImpl userDetails) {
        likeLectureService.toggleLike(lectureId, userDetails);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
