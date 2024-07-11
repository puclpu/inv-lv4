package com.sparta.spartalecture.comment.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CommentUpdateRequestDto {

    @NotBlank(message = "값이 입력되지 않았습니다")
    @Max(value = 150, message = "최대 150자까지 입력할 수 있습니다")
    private String content;
}
