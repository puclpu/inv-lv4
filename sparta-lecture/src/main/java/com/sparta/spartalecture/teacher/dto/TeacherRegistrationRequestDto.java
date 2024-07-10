package com.sparta.spartalecture.teacher.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class TeacherRegistrationRequestDto {
    @NotBlank(message = "값을 입력하지 않았습니다")
    private String name;

    private int experience;

    @NotBlank(message = "값을 입력하지 않았습니다")
    private String company;

    @NotBlank(message = "값을 입력하지 않았습니다")
    private String phone;

    @NotBlank(message = "값을 입력하지 않았습니다")
    private String introduce;
}
