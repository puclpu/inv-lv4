package com.sparta.spartalecture.teacher.dto;

import com.sparta.spartalecture.teacher.domain.Teacher;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class TeacherInfoResponseDto {
    private Long id;
    private String name;
    private int experience;
    private String company;
    private String introduce;

    public static TeacherInfoResponseDto from(Teacher teacher) {
        return TeacherInfoResponseDto.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .experience(teacher.getExperience())
                .company(teacher.getCompany())
                .introduce(teacher.getIntroduce())
                .build();
    }
}
