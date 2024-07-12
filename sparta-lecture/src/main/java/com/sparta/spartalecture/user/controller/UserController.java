package com.sparta.spartalecture.user.controller;

import com.sparta.spartalecture.security.service.UserDetailsImpl;
import com.sparta.spartalecture.user.dto.SignupRequestDto;
import com.sparta.spartalecture.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping
    public ResponseEntity<Void> withdraw(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        userService.withdraw(userDetails);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
