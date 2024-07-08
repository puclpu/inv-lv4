package com.sparta.spartalecture.user.service;

import com.sparta.spartalecture.user.dto.SignupRequestDto;
import com.sparta.spartalecture.user.domain.User;
import com.sparta.spartalecture.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signup(SignupRequestDto requestDto) {
        String password = passwordEncoder.encode(requestDto.getPassword());

        // 중복 이메일 확인
        if (userRepository.existsByEmail(requestDto.getEmail())) {
            throw new RuntimeException("동일한 회원이 존재합니다.");
        }

        // 사용자 등록
        User user = User.of(requestDto, password);
        userRepository.save(user);
    }
}
