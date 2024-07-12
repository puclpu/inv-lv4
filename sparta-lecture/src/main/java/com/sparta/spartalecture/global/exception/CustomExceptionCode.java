package com.sparta.spartalecture.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CustomExceptionCode {

    MEMBER_EXISTS(HttpStatus.CONFLICT, "해당 이메일의 회원이 이미 존재합니다."),
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 회원입니다"),
    TEACHER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 강사는 존재하지 않습니다."),
    LECTURE_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 강의는 존재하지 않습니다."),
    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 댓글은 존재하지 않습니다."),
    COMMENT_ACCESS_DENIED(HttpStatus.FORBIDDEN, "해당 댓글 작성자만 작업할 수 있습니다.");

    private final HttpStatus status;
    private final String message;
}
