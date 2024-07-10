package com.sparta.spartalecture.lecture.dto;

import com.sparta.spartalecture.lecture.type.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class LectureRegistrationRequestDto {
    @NotBlank(message = "값을 입력하지 않았습니다.")
    private String title;

    private int price;

    @NotBlank(message = "값을 입력하지 않았습니다.")
    private String introduce;

    @NotNull(message = "값을 입력하지 않았습니다.")
    private Category category;

    @NotNull(message = "값을 입력하지 않았습니다.")
    private Long teacherId;
}
