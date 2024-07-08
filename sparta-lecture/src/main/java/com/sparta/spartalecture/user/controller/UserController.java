package com.sparta.spartalecture.user.controller;

import com.sparta.spartalecture.user.dto.SignupRequestDto;
import com.sparta.spartalecture.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> signup (@RequestBody @Valid SignupRequestDto requestDto) {
        userService.signup(requestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
