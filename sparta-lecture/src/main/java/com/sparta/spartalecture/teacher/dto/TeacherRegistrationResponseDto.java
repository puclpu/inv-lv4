package com.sparta.spartalecture.teacher.dto;

import com.sparta.spartalecture.teacher.domain.Teacher;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class TeacherRegistrationResponseDto {
    private Long id;
    private String name;
    private int experience;
    private String company;
    private String phone;
    private String introduce;

    public static TeacherRegistrationResponseDto from(Teacher teacher) {
        return TeacherRegistrationResponseDto.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .experience(teacher.getExperience())
                .company(teacher.getCompany())
                .phone(teacher.getPhone())
                .introduce(teacher.getIntroduce())
                .build();
    }
}
