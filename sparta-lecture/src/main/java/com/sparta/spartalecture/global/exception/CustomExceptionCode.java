package com.sparta.spartalecture.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CustomExceptionCode {

    MEMBER_EXISTS(HttpStatus.CONFLICT, "해당 이메일의 회원이 이미 존재합니다."),
    TEACHER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 강사는 존재하지 않습니다."),
    LECTURE_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 강의는 존재하지 않습니다.");

    private final HttpStatus status;
    private final String message;
}
